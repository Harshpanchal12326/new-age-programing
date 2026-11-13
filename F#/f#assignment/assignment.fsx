#r "nuget: MongoDB.Driver"

open MongoDB.Driver

[<CLIMutable>]
type Book = {
    Id: int
    Title: string
    Pages: int
    Available: bool
}

let getStatus b =
    match b.Available with
    | true -> "Available"
    | false -> "Issued"

let books = [
    { Id = 1; Title = "art of lazyness"; Pages = 250; Available = true }
    { Id = 2; Title = "harry-potter"; Pages = 400; Available = false }
    { Id = 3; Title = "journey to the end of the earth"; Pages = 400; Available = false }
]

let availableBooks = books |> List.filter (fun b -> b.Available)
let titles = books |> List.map (fun b -> b.Title)

let client = new MongoClient("mongodb+srv://harshpanchal12326_db_user:VHq5KVBQkGgDLRQE@cluster0.2j4xuiq.mongodb.net/?compressors=zlib")
let collection = client.GetDatabase("LibraryDB").GetCollection<Book>("books")

let createBook (b: Book) =
    async {
        do! collection.InsertOneAsync(b) |> Async.AwaitTask
        printfn "Create: %s" b.Title
    }

let readBooks () =
    async {
        let! cursor = collection.FindAsync(Builders<Book>.Filter.Empty) |> Async.AwaitTask
        let! docs = cursor.ToListAsync() |> Async.AwaitTask
        printfn "Read Books:"
        for b in docs do
            printfn "  %d %s %d %s" b.Id b.Title b.Pages (getStatus b)
    }

let updateBook id available =
    async {
        let filter = Builders<Book>.Filter.Eq("Id", id)
        let update = Builders<Book>.Update.Set("Available", available)
        let! _ = collection.UpdateOneAsync(filter, update) |> Async.AwaitTask
        printfn "Update: Book %d Available = %b" id available
    }

let deleteBook id =
    async {
        let filter = Builders<Book>.Filter.Eq("Id", id)
        let! _ = collection.DeleteOneAsync(filter) |> Async.AwaitTask
        printfn "Delete: Book %d" id
    }

let main =
    async {
        let! _ = collection.DeleteManyAsync(Builders<Book>.Filter.Empty) |> Async.AwaitTask

        for b in books do
            do! createBook b

        do! readBooks ()

        do! updateBook 2 true

        do! deleteBook 1

        do! readBooks ()
    }

Async.RunSynchronously main
