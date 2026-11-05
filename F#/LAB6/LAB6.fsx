// open System


// printf "Enter marks for Subject 1: "
// let subject1 = float (Console.ReadLine())

// printf "Enter marks for Subject 2: "
// let subject2 = float (Console.ReadLine())

// printf "Enter marks for Subject 3: "
// let subject3 = float (Console.ReadLine())

// printf "Enter marks for Subject 4: "
// let subject4 = float (Console.ReadLine())


// let total = subject1 + subject2 + subject3 + subject4
// let percentage = total / 4.0


// let division =
//     match percentage with
//     | p when p >= 60.0 -> "First Division"
//     | p when p >= 50.0 -> "Second Division"
//     | p when p >= 40.0 -> "Third Division"
//     | _ -> "Fail"


// printfn ""
// printfn "Total Marks: %.2f / 400" total
// printfn "Percentage: %.2f%%" percentage
// printfn "Division: %s" division



// Question 2: Check Prime Number (Recursive / Functional Approach)


// open System

// let isPrime n =
//     if n <= 1 then
//         false
//     else
//         let rec checkDivisor d =
//             if d * d > n then
//                 true
//             elif n % d = 0 then
//                 false
//             else
//                 checkDivisor (d + 1)
//         checkDivisor 2


// let printResult n =
//     if isPrime n then
//         printfn "%d is a Prime number" n
//     else
//         printfn "%d is NOT a Prime number" n

// let testInputs = [ 2; 15; 29; 1 ]


// testInputs |> List.iter printResult
// printf "\nEnter an integer to check: "
// let userInput = int (Console.ReadLine())
// printResult userInput




// Question 3: String Processing with Pattern Matching


open System
open System.Text.RegularExpressions


let checkPalindrome (str: string) =
    let reversed = new string (str.ToCharArray() |> Array.rev)
    match str.ToLower() = reversed.ToLower() with
    | true  -> printfn "\"%s\" -> Reversed: \"%s\" -> Palindrome" str reversed
    | false -> printfn "\"%s\" -> Reversed: \"%s\" -> Not a Palindrome" str reversed


let transformString (str: string) =
    let isAlpha = str.Length > 0 && (str |> Seq.forall Char.IsLetter)
    let isNumeric = str.Length > 0 && (str |> Seq.forall Char.IsDigit)

    match (isAlpha, isNumeric) with
    | (true, false) -> str.ToUpper()            
    | (false, true) -> string (int str * 2)     
    | _             -> str                      


let validateEmail (email: string) =
    let pattern = @"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
    match Regex.IsMatch(email, pattern) with
    | true  -> printfn "\"%s\" -> Valid Email" email
    | false -> printfn "\"%s\" -> Invalid Email" email


checkPalindrome "madam"
checkPalindrome "racecar"
checkPalindrome "hello"

printfn "\n=== Task 2: String Transformation ==="
let inputs2 = [ "hello"; "25"; "abc123" ]
for s in inputs2 do
    printfn "Input: \"%s\" -> Output: \"%s\"" s (transformString s)

printfn "\n=== Task 3: Email Validation ==="
validateEmail "student@example.com"
validateEmail "user.name@college.edu"
validateEmail "invalid-email-address"
