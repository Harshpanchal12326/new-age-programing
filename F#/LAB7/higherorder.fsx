
open System


let jobs = [
    async { return "Job 1" }
    async { return "Job 2" }
    async { return "Job 3" }
]


let parallelTask = Async.Parallel jobs

let results = Async.RunSynchronously parallelTask


results
|> Array.iter (fun result ->
    printfn "Completed %s" result)


let numbers = [1; 2; 3]

numbers
|> List.fold (fun acc x -> acc + x) 0
|> printfn "%d"


numbers
|> List.sum
|> printfn "%d"