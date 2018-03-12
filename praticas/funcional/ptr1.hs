-- Exercicio 1
somaQuad :: Int -> Int -> Int
somaQuad x y = x^2 + y^2

-- Exercicio 2
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads lis1 lis2 = (head lis1) == (head lis2)

-- Exercicio 3
funcStrAux :: String -> String
funcStrAux x = "Super " ++ x
funcStr:: [String] -> [String]
funcStr lis = map funcStrAux lis

-- Exercicio 4
funcWSpaceAux :: String -> [Bool]
funcWSpaceAux str = map (\x -> x == ' ') str
funcWSpace :: String -> Int
funcWSpace str = length(filter (\x -> x) (funcWSpaceAux str))

-- Exercicio 5
funcOpr5 :: [Double]->[Double]
funcOpr5 lis = map (\x -> 3 * x^2 + 1 + 2/x) lis

-- Exercicio 6
funcNegative :: [Int] -> [Int]
funcNegative lis = filter (\x -> x < 0) lis

-- Exercicio 7
funcinCem :: [Int] -> [Int]
funcinCem lis = filter (\x -> x > 0 && x < 101) lis

-- Exercicio 8
funcEightAux :: Int -> Int
funcEightAux x = 2017 - x
funcEight :: [Int] -> [Int]
funcEight lis = filter (\x -> (funcEightAux x) > 1980) lis

-- Exercicio 9
funcPairs :: [Int] -> [Int]
funcPairs lis = filter (\x -> x `mod` 2 == 0) lis

-- Exercicio 10
charFound :: Char -> String -> Bool 
charFound ch str = length(filter (\x -> x == ch) str) > 0

-- Exercicio 11
funcOnze :: [String] -> [String]
funcOnze lis = filter (\x -> (last x) == 'a') lis

-- Exercicio 12
-- takeWhile :: (a -> Bool) -> [a] -> [a]
