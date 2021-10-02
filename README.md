Написать программу (консольное приложение), анализирующую отчет о товарообороте
гипермаркета.
Формат входных данных
1. Отчет о товарообороте должен считываться программой из файла с именем input.txt.
2. Каждая строка файла хранит информацию о суммарной выручке от продаж товаров одного
конкретного наименования за один день. Эта информация представлена в виде трёх
значений, разделенных символом ‘#’:
1) наименование товара;
2) дата продаж товара;
3) суммарная выручка от продажи товара с этим наименованием за эту дату.
3. Наименование товара задано в виде последовательности любых символов (за исключением
самого символа ‘#’ или символов переноса строки), длиной не более 50 символов.
4. Дата продаж товара задана в формате dd.MM.yyyy, где dd – двухзначное число дня месяца,
MM – номер месяца, yyyy – год (например, строка «31.12.2017» означает дату «31 декабря
2017 года»).
5. Суммарная выручка от продажи товара в указанную дату задана в виде целого
положительного числа (количества гривен) из диапазона [1; 10000000].
6. Количество строк в файле не превышает 1000.
Требования к приложению
Обработав данные отчёта, программа должна найти товар, от продаж которого гипермаркет
получил наибольшую суммарную выручку за все (!) даты, а также дату последней продажи этого
товара.
Примечание. Реализовывать проверки выхода значений за допустимые пределы не нужно.
Достаточно, чтобы программа умела работать со значениями, находящимися в этих пределах.
Формат выходных данных
1. Программа должна выводить на экран три значения, разделенные пробелом:
1) наименование найденного товара;
2) дату последней продажи найденного товара;
3) суммарную выручку от всех продаж найденного товара, информация о которых
присутствует во входном отчёте.
2. Формат всех трёх выходных значений должен совпадать с форматом соответствующих
входных значений (см. пп. 3,4,5).
Пример
В приведенной ниже таблице показан пример исходных данных (содержимого файла input.txt) и
соответствующих выходных данных — результата, который должна выдать программа.
input.txt Правильный результат
Яблоко "Голден"#03.03.2017#2300
Хлеб ржаной#04.03.2017#1800
Утюг "Scarlett"#02.03.2017#2200
Молоко "Ферма", 3,2%#01.03.2017#2500
Молоко "Ферма", 3,2%#10.03.2017#1250
Яблоко "Голден"#03.03.2017#1150
Хлеб ржаной#01.03.2017#2700
Хлеб ржаной 04.03.2017 45