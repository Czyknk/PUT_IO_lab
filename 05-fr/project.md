# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC5](#uc5): Przekazanie produktu Kupującemu

[Kupujący](#ac2)
* [UC2](#uc2): Złożenie oferty kupna
* [UC3](#uc3): Wygranie aukcji
* [UC4](#uc4): Przekazanie należności sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Złożenie oferty kupna

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) składa ofertę kupna produktu.
2. System prosi o podanie wysokości oferty.
3. [Kupujący](#ac2) podaje wysokość oferty.
4. System sprawdza czy złożona oferta jest wyższa niż aktualnie najwyższa oferta.
5. System informuje o pomyśnym wzięciu udziału w aukcji.

**Scenariusze alternatywne:** 

4.A. Podana oferta jest niższa niż aktualnie najwyższa oferta
* 4.A.1. System informuje o błędzie podanych danych.
* 4.A.2. Przejdź do koku 2.

---

<a id="uc3"></a>
### UC3: Wygranie aukcji

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. System w momencie zakończenia aukcji sprawdza czy oferta przedstawiona przez [kupującyego](#ac2) jest nadal najwyższa.
2. System informuje o wygranej aukcji.
3. System informuje [Kupującego](#ac2) o konieczności [przekazania należność Sprzedającemu](#uc4)

**Scenariusze alternatywne:** 

1.A. Podana oferta jest niższa niż aktualnie najwyższa oferta
* 1.A.1. System informuje o przegraniu aukcji.

---

<a id="uc4"></a>
### UC4: Przekazanie należność

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System prosi [kupującego](#ac2) o wybranie metody i danych do płatności
2. [Kupujący](#ac2) wybiera metodę płatności oraz wprowadza dane.
3. System weryfikuje poprawność danych.
4. System informuje [kupującego](#ac2) o poprawnym dokonaniu płatności.
5. System informuje [Sprzedającego](#ac1) o złożeniu płatności przez kupującego.

**Scenariusze alternatywne:** 

3.A. Podane dane są błędne
* 3.A.1. System informuje [kupującego](#ac2) o błędzie podanych danych.
* 3.A.2. Przejdź do kroku 1.

---

<a id="uc5"></a>
### UC5: Przekazanie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wybiera metodę przekazania produktu i wprowadza dane adresowe.
2. System weryfikuje poprawność danych.
3. System informuje o pomyślnym zakończeniu aukcji.

**Scenariusze alternatywne:** 

3.A. Wprowadzione dane adresowe są niepoprawne
* 2.A.1. System informuje [kupującego](#ac2) o błędzie podanych danych.
* 3.A.2. Przejdź do kroku 1.

---

## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| UC2: Złożenie oferty kupna                        |    C   |    C    | ... |
| UC3: Wygranie aukcji                              |    C   |         | ... |
| UC4: Przekazanie należności sprzedającemu         |        |         | ... |
| UC5: Przekazanie produktu Kupującemu              |    C   |    C    | ... |




