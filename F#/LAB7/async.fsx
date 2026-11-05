let task name (delay: int) =
    async {
        printfn "Task %s started" name
        do! Async.Sleep delay
        printfn "Task %s finished" name
        return name
    }

printfn "Starting tasks..."

let tasks = [
    task "A" 3000
    task "B" 1000
    task "C" 2000
]

let results = tasks |> Async.Parallel |> Async.RunSynchronously

printfn "\nResults:" 
results |> Array.iter (printfn "Task %s completed")



