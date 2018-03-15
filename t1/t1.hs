import Data.Char
-- Exercicio 1
isVowel :: Char -> Bool
isVowel ch = length(filter (\x -> x == ch) "aAeEiIoOuU") > 0

-- Exercicio 2
addComma :: [String] -> [String]
addComma lis = map (\x -> x ++ ",") lis

-- Exercicio 3
htmlListItemsAux :: String -> String
htmlListItemsAux str = "<LI>" ++ str ++ "</LI>"
htmlListItems2 :: [String] -> [String]
htmlListItems2 lis = map htmlListItemsAux lis

htmlListItems :: [String] -> [String]
htmlListItems lis = map (\x -> "<LI>" ++ x ++ "</LI>") lis

-- Exercicio 4
notVowel :: Char -> Bool
notVowel ch = length(filter (\x -> x == ch) "aAeEiIoOuU") == 0
semVogais :: String -> String
semVogais str = filter notVowel str

semVogais2 :: String -> String
semVogais2 str = filter (\x -> not (isVowel x)) str

-- Exercicio 5
codAux :: Char -> Char
codAux ch = if ch == ' ' then ' ' else '-'
codifica2 :: String -> String
codifica2 str = map codAux str
codifica :: String -> String
codifica str = map (\x -> (if x == ' ' then ' ' else '-')) str

-- Exercicio 6
firstName :: String -> String
firstName str = takeWhile (/= ' ') str

-- Exercicio 7
isIntAux :: Char -> Bool
isIntAux ch = length(filter(\x -> x == ch) "0123456789") == 0
isInt :: String -> Bool
isInt sInt = length(filter isIntAux sInt) == 0

-- Exercicio 8
lastName :: String -> String
lastName str = last (words str)
-- Abaixo não funciona corretamente
-- lastName str = filter (\x -> x /= ' ') (dropWhile (/= ' ') str)

-- Exercicio 9
userName :: String -> String
userName str = map (\x -> toLower x) (take 1 str ++ lastName str)

-- Exercicio 10
encodeMe :: Char -> Char
encodeMe c
  | c == 'a'  = '4'
  | c == 'e'  = '3'
  | c == 'i'  = '2'
  | c == 'o'  = '1'
  | c == 'u'  = '0'
  | otherwise = c
encodeName :: String -> String
encodeName str = map (\x -> encodeMe(toLower x)) str

-- Exercicio 11
betterencodeMe :: Char -> String
betterencodeMe c
  | c == 'a'  = "4"
  | c == 'e'  = "3"
  | c == 'i'  = "2"
  | c == 'o'  = "0"
  | c == 'u'  = "00"
  | otherwise = [c]
betterEncodeName :: String -> String
betterEncodeName str = concatMap (\x -> betterencodeMe(toLower x)) str

-- Exercicio 12
func :: [String] -> [String]
func lis = map (\x -> take 10 (x ++ "..........")) lis
