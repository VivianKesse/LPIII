import random


def rolaDados():
    d1 = random.randrange(start=1, stop=7)
    d2 = random.randrange(start=1, stop=7)
    print(f"Dado1 {d1}")
    print(f"Dado2 {d2}")
    return d1, d2


def main():
    print("Estágio 1:")
    dado1, dado2 = rolaDados()
    soma = dado1 + dado2
    if soma == 7 or soma == 11:
        print("Ganhou!")
    elif soma == 2 or soma == 3 or soma == 12:
        print("Perdeu!")
    else:
        ponto = soma
        print("\nEstágio 2:")
        print(f"Ponto: {ponto}")

        x = 1
        while True:
            dado1, dado2 = rolaDados()
            soma = dado1 + dado2
            print(f"Jogada {x}: {soma}")
            if soma == 7:
                print("Perdeu!")
                break
            elif soma == ponto:
                print("Ganhou!")
                break
            else:
                x += 1


main()
