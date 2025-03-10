### Количество перестановок из 4 цифр

Чтобы посчитать количество перестановок, используем **факториал** n!.

Формула для перестановок:
P(n) = n!

Для 4 цифр:
4! = 4 × 3 × 2 × 1 = 24

**Ответ:** можно сделать **24 перестановки** из 4 цифр.

---

### Количество уникальных выборок из 4 цифр (без учёта порядка)

Если порядок не важен, используем **сочетания без повторений**.

Формула для сочетаний:
C(n, k) = n! / (k! × (n-k)!)

Где:

- n — общее количество элементов (в данном случае 4),
- k — количество элементов, которые выбираются (в данном случае 3).

Подставляем значения:
C(4, 3) = 4! / (3! × (4-3)!) = (4 × 3 × 2 × 1) / ((3 × 2 × 1) × 1) = 24 / 6 = 4

**Ответ:** можно сделать **4 уникальных выборки** из 3 цифр, если порядок не важен.

---

### Количество выборок из 4 цифр (с учётом порядка)

Если порядок важен, используем **размещения без повторений**.

Формула для размещений:
A(n, k) = n! / (n-k)!

Где:

- n — общее количество элементов (4),
- k — количество элементов, которые выбираются с учётом порядка (3).

Подставляем значения:
A(4, 3) = 4! / (4-3)! = (4 × 3 × 2 × 1) / 1! = 4 × 3 × 2 = 24

**Ответ:** можно сделать **24 уникальных размещения**, если порядок важен.

---

### Примеры

Если цифры — {1, 2, 3, 4}:

1. **Сочетания (порядок не важен):**
   {1, 2, 3}, {1, 2, 4}, {1, 3, 4}, {2, 3, 4}
   Всего **4**.

2. **Размещения (порядок важен):**
   {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, ...
   Всего **24**.
