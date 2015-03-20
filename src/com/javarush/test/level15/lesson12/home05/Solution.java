package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(int pub1){}
    public Solution (String pub1){}
    public Solution (double pub1){}

    private Solution(Object priv1, int priv2){}
    private Solution (String priv1, int priv2){}
    private Solution (double priv1, int priv2){}

    protected Solution(int prot1, int prot2){}
    protected Solution (int prot2, String prot1){}
    protected Solution (double prot1, double prot2){}

    Solution (){}
    Solution (int def1, double def2, int def3){}
    Solution (double def1, int def2, int def3){}

}

