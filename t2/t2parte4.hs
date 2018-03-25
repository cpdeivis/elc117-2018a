import Data.Char

-- Converte um caracter em um inteiro
encodeChar :: Char -> Int
encodeChar c = ord c - ord 'a'
-- Converte um inteiro em um caracter
decodeChar :: Int -> Char
decodeChar n = chr (ord 'a' + n)
-- Calcula percentagem: n/m*100
percent :: Int -> Int -> Float
percent n m = (fromIntegral n / fromIntegral m)*100
-- Rotacao de uma lista para esquerda em n posicoes
rotate :: Int -> [a] -> [a]
rotate n xs = drop n xs ++ take n xs
-- Tabela de frequencias das letras 'a'..'z' (lingua portuguesa)
-- https://pt.wikipedia.org/wiki/Frequ%C3%AAncia_de_letras
table :: [Float]
table = [14.6, 1.0, 3.9, 5.0, 12.6, 1.0, 1.3, 1.3, 6.2, 0.4, 0.1, 2.8, 4.7,
         5.0, 10.7, 2.5, 1.2, 6.5, 7.8, 4.3, 4.6, 1.7, 0.1, 0.2, 0.1, 0.5]
-- Distancia entre 2 listas de frequencia
chi2 :: [Float] -> [Float] -> Float
chi2 os es = sum [((o-e)^2)/e | (o,e) <- zip os es]
-- Use esta funcao para decodificar uma mensagem!
crack :: String -> String
crack cs = encodeStr cs (-factor)
           where factor = head (positions (minimum chitab) chitab)
                 chitab = [ chi2 (rotate n table' ) table | n <- [0..25] ]
                 table' = freqs cs

-- Aqui Começa as Outras Implementações
-- Exercicio 1
shiftChar :: Char -> Int -> Char
shiftChar ch n
  | (encodeChar ch) > 25 || (encodeChar ch) < 0 = ch
  | n >= 25 =  shiftChar ch (n-25)
  | ((encodeChar ch) + n) > 25 = shiftChar 'a' (n-1)
  | otherwise = decodeChar ((encodeChar ch) + n)

-- Exercicio 2
encodeStr :: String -> Int -> String
encodeStr str n = map (\x -> shiftChar x n) str

-- Exercicio 3
countValids :: String -> Int
countValids str = length(filter (\x -> ord x > 96 && ord x < 123) str)

-- Exercicio 4
countChar :: Char -> String -> Int
countChar ch str = length(filter (\x -> ord x == ord ch) str)

-- Exercicio 5
freqs :: String -> [Float]
freqs str = [ percent (countChar x str) y | x <- ['a'..'z'], y <- [countValids str]]

-- Exercicio 6
positions :: Float -> [Float] -> [Int]
positions fl lis = map (\x -> snd x) (filter (\x -> (fst x) == fl) (zip lis [0..(length lis - 1)]))
