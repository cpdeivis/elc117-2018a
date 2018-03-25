import Data.Char

-- Exercicio 1
isBin :: String -> Bool
isBin "" = False
isBin "0" = True
isBin "1" = True
isBin str = ((head str) == '0' || (head str) == '1') && isBin (tail str)

-- Exercicio 2
isBin' :: String -> Bool
isBin' "" = False
isBin' str = length(filter (\x -> x /= '0' && x /= '1') str) == 0

-- Exercicio 3 = Não Funciona Ainda
auxBin2Dec :: [Int] -> Int -> Int
auxBin2Dec [] n = 0
auxBin2Dec bits n = (((head bits) * 2)^n) + (auxBin2Dec (tail bits) ((length bits)-1))

bin2dec :: [Int] -> Int
bin2dec [] = undefined
bin2dec bits = auxBin2Dec bits ((length bits)-1)

-- Exercicio 4

-- Exercicio 5

-- Exercicio 6
isHex :: String -> Bool
isHex str = length (filter (\x -> not (isHexDigit(x))) str) == 0
