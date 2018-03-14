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
codifica :: String -> String
codifica str = map (\x -> (if x == ' ' then ' ' else '-')) str

-- Exercicio 6
firstName :: String -> String
firstName str = head(span (== " ") str)