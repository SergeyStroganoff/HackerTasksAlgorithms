Задача о разрезании стержня
Условие: Дан стержень длиной n см. Также дан массив p[i], содержащий цены для стержня длиной i см,
где 1 <= i <= n.
Необходимо найти максимальную прибыль, которую можно получить,
разрезав стержень и продав его куски.!

![](table.png)
решение: https://www.youtube.com/watch?v=QyJP7IXGwHM&ab_channel=OleksandrTsymbaliuk
Начнем с решения задачи методом динамического программирования.
Для начала, рассмотрим простейший случай, когда стержень длиной n см.
Для этого случая, у нас есть два варианта:
1. Продать стержень целиком, получив прибыль p[n].
2. Разрезать стержень на две части, длиной i и n-i см, и продать их.
   Прибыль в этом случае будет равна p[i] + p[n-i].
Таким образом, максимальная прибыль, которую можно получить, разрезав стержень длиной n см, равна
max(p[n], p[i] + p[n-i]) для всех 1 <= i <= n.


