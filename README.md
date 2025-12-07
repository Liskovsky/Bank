# Bankovní Systém a Utility

Tento projekt v jazyce Java implementuje základní **objektově orientovaný model** pro správu bankovních účtů, klientů a jejich osobních údajů. Součástí je i vlastní generická implementace seznamu a modul pro evidenci tankování.

---

## Struktura a Klíčové Třídy

Systém je rozdělen do modulů reprezentujících základní bankovní entity a pomocné datové struktury.

### 1. Bankovní Entita

| Třída | Popis | Klíčové Funkce |
| :--- | :--- | :--- |
| **`Client`** | Reprezentuje klienta banky. Obsahuje `Person` a `Account` a `bankID`. | Operace vkladu/výběru, porovnání dle `bankID`. |
| **`Account`** | Bankovní účet s `accountID`, `balance` a přidruženou `Card`. | `deposit(amount)`, `cashOut(amount)`, porovnání dle `accountID`. |
| **`Card`** | Platební karta (ID, typ karty, kreditní/debetní status). | Gettery/Settery. |
| **`Person`** | Osobní údaje klienta (jméno, příjmení, rok narození, `Adress`). | Třídění podle jména/příjmení, kontrola validity jména/příjmení. |
| **`Adress`** | Adresa bydliště (ulice, číslo popisné, město, PSČ). | Porovnání dle ulice a města. |

### 2. Serializace a Persistence

Všechny hlavní třídy (`Client`, `Account`, `Person`, `Adress`) implementují metody:
* `toTxt()`: Převede objekt do textového řetězce pro uložení.
* `fromTxt(String line)`: Vytvoří nový objekt z uloženého textového řetězce.

---

## Datová Struktura

### Vlastní Seznam (`ListImplement<T>`)

* Implementuje rozhraní `List<T)`, kde `T` musí implementovat `Comparator`.
* **Třídění:** Data jsou udržována v seřazeném stavu. Metoda `sortData()` využívá algoritmus **Bubble Sort** s metodou `compare()` z objektu `T`.
* **Omezení:** Pevná kapacita (50 prvků). Přidání do plného seznamu vyvolá výjimku (`RuntimeException`).

---


## Testy (JUnit)

Projekt je vybaven sadou testů pro zajištění správné funkčnosti.

* **`PersonTest`**: Testuje konstruktory, serializaci (`toTxt`/`fromTxt`) a vyhazování výjimek (`NullPointerException`) při neplatných vstupech.
