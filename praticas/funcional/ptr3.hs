-- Exercicio 1
addSufix :: String -> [String] -> [String]
addSufix sux lis = [ b ++ a | a <- [sux], b <- lis]

-- Exercicio 2
countShorts :: [String] -> Int
countShorts lis = length [ x | x <- lis, (length x) < 5]

-- Exercicio 4
genRects :: Int -> (Int, Int) -> [(Float, Float, Float, Float)]
genRects n (tup, linha) = [(x,y,larg,alt) | x <- take n [fromIntegral(tup),5.5..], y <- [fromIntegral(linha)], larg <- [5.5], alt <- [5.5]]
