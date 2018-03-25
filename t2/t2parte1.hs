-- Exercicio 1
geraTabela :: Int -> [(Int, Int)]
geraTabela 0 = []
geraTabela n = (n, n*n) : geraTabela (n-1)

-- Exercicio 2
contido :: Char -> String -> Bool
contido ch [] = False
contido ch str = ch == (last str) || contido ch (init str)

-- Exercicio 3
translate :: [(Float, Float)] -> [(Float, Float)]
translate [] = []
translate lis = ((fst (head lis)) + 2.0, (snd (head lis)) + 2.0) : translate (tail lis)

-- Exercicio 4
rreverse :: [(Int, Int)] -> [(Int, Int)]
rreverse [] = []
rreverse lis = (last lis) : rreverse (init lis)
geraTabela2 :: Int -> [(Int, Int)]
geraTabela2 0 = []
geraTabela2 n = rreverse (geraTabela n)

auxGera3 :: Int -> Int -> [(Int, Int)]
auxGera3 n 0 = []
auxGera3 n nn = (n, n*n) : auxGera3 (n+1) (nn-1)
geraTabela3 :: Int -> [(Int, Int)]
geraTabela3 0 = []
geraTabela3 n = auxGera3 1 n
