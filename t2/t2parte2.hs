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

-- Exercicio 3
auxBin2Dec :: [Int] -> Int -> Int
auxBin2Dec [] n = 0
auxBin2Dec [0] n = 0
auxBin2Dec bits n = (((head bits) * 2)^n) + (auxBin2Dec (tail bits) (n-1))

bin2dec :: [Int] -> Int
bin2dec [] = undefined
bin2dec bits = auxBin2Dec bits ((length bits)-1)

-- Exercicio 4
bin2dec' :: [Int] -> Int
bin2dec' [] = undefined
bin2dec' bits = sum(map (\x -> if (fst x) == 1 then ((fst x)*2)^(snd x) else 0) (zip (reverse bits) [0..]))

-- Exercicio 5
dec2bin' :: Int -> [Int]
dec2bin' 0 = []
dec2bin' n = (mod n 2) : dec2bin' (div n 2)

dec2bin :: Int -> [Int]
dec2bin 0 = [0]
dec2bin n = reverse (dec2bin' n)

-- Exercicio 6
isHex :: String -> Bool
isHex str = length (filter (\x -> not (isHexDigit(x))) str) == 0
