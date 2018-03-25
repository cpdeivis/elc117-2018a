import Data.Char

isIntAux :: Char -> Bool
isIntAux ch = length(filter(\x -> x == ch) "0123456789") == 0
isInt :: String -> Bool
isInt sInt = length(filter isIntAux sInt) == 0

isPair :: Int -> Int
isPair n = if n `mod` 2 == 0 then 3 else 1

isEanOkAux' :: String -> Int -> [Int]
isEanOkAux' [] n = []
isEanOkAux' str n = ((digitToInt(last str)) * (isPair n)) : isEanOkAux' (init str) (n-1)
isEanOkAux :: String -> Int
isEanOkAux str = (10*(round(fromIntegral(sum(isEanOkAux' str 12))/10))) - sum(isEanOkAux' str 12)

isEanOk :: String -> Bool
isEanOk str
  | (length str) /= 13 = False
  | not (isInt str) = False
  | otherwise = (intToDigit(abs(isEanOkAux (init str))) == (last str))
