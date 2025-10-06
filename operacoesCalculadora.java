public class operacoesCalculadora{

    public static String adicaoComplexa(double vR1, double vI1, double vR2, double vI2) {
            double addReal = (vR1 + vR2);
            double addImagi = (vI1 + vI2);
            String resultAdd = addReal + " + " + addImagi + "i";
            System.out.println("A soma de " + vR1 + " + " + vI1 + "i " + "com " + vR2 + " + " + vI2 + "i " + "é igual a " + resultAdd);
            return resultAdd;
    }

    public static String subtracaoComplexa(double vR1, double vI1, double vR2, double vI2) {
        double subReal = (vR1 - vR2);
        double subImagi = (vI1 - vI2);
        String resultSub = subReal + " + " + subImagi + "i";
        System.out.println("A soma de " + vR1 + " + " + vI1 + "i " + "com " + vR2 + " + " + vI2 + "i " + "é igual a " + resultSub);
        return resultSub;
    }

    /* public static String multiComplexa(double vR1, double vI1, double vR2, double vI2) {
        double multiReal = (vR1 * vR2) + (vR1 * vI2) + (vI1 * vR2) + (vI1 * vI2);
        double multiImagi = 

        return resultMulti;
    } */
}