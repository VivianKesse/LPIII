class Player:
    qtdNavios = 5

    def __init__(self, id):
        self.__mapa = list()
        self.__nome = f'Player {id}'
        self.__MAX_COORD = 4
        self.__MIN_COORD = 0
        self.__VAZIO = '-'
        self.__NAVIO = '@'
        self.__AFUNDADO = 'X'
        self.__BOMBA = 'O'
        self.__ganhou = False
        self.__qtdNaviosPerdidos = 0

        self.inicializaMapa()

    def getNome(self):
        return self.__nome

    def ganhou(self):
        return self.__ganhou

    def getNaviosPerdidos(self):
        return self.__qtdNaviosPerdidos

    def getPonto(self, x, y):
        return self.__mapa[x][y]

    def inicializaMapa(self):
        for i in range(self.__MAX_COORD+1):
            self.__mapa.append([self.__VAZIO]*(self.__MAX_COORD+1))

    def insereCoordenadas(self, tempx, tempy):
        if tempx > self.__MAX_COORD or tempy > self.__MAX_COORD or tempx < self.__MIN_COORD or tempy < self.__MIN_COORD:
            return 'Invalid coordinates. Choose different coordinates.'
        else:
            existe = False
            if self.__mapa[tempx][tempy] == self.__NAVIO:
                existe = True

            if existe:
                return 'You already have a ship there. Choose different coordinates.'
            else:
                self.__mapa[tempx][tempy] = self.__NAVIO
                return ''

    def exibeMapaPlayer(self):
        print('\n\n  0  1  2  3  4')
        for i in range(self.__MAX_COORD+1):
            print(i, end='')
            for j in range(self.__MAX_COORD+1):
                print(f" {self.__mapa[i][j]} ", end='')
            print()

    def exibeMapaGame(self):
        print('\n\n  0  1  2  3  4')
        for i in range(self.__MAX_COORD+1):
            print(i, end='')
            for j in range(self.__MAX_COORD+1):
                temp = self.__mapa[i][j]
                if temp == self.__NAVIO:
                    print(f' {self.__VAZIO} ', end='')
                else:
                    print(f' {self.__mapa[i][j]} ', end='')
            print()

    def perdeuNavio(self, x, y):
        self.__mapa[x][y] = self.__AFUNDADO
        self.__qtdNaviosPerdidos += 1

    def tiroBomba(self, x, y):
        self.__mapa[x][y] = self.__BOMBA

    def atiraEm(self, alvo, tempx, tempy):
        if tempx > self.__MAX_COORD or tempy > self.__MAX_COORD or tempx < self.__MIN_COORD or tempy < self.__MIN_COORD:
            print('Invalid coordinates. Choose different coordinates.')
            return False

        ponto = alvo.getPonto(tempx, tempy)

        if ponto == self.__NAVIO:
            alvo.perdeuNavio(tempx, tempy)
            print(f'{self.__nome} hit {alvo.getNome()}\'s Ship!!!')
            if alvo.getNaviosPerdidos() == Player.qtdNavios:
                self.__ganhou = True
            return True

        elif ponto == self.__VAZIO:
            alvo.tiroBomba(tempx, tempy)
            print(f'{self.__nome}, MISSED!')
            return True

        elif ponto == self.__BOMBA or ponto == self.__AFUNDADO:
            print('You already fired on this spot. Choose different coordinates.')
            return False
