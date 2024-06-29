package facade;

import adapter.BatchCalculationAdapter;
import adapter.BatchCalculationAdapterImpl;
import controller.Controller;
import factory.BatchCalculationFactory;
import factory.BatchSubtractionFactory;
import factory.BatchSumFactory;
import factory.CalculationFactory;
import factory.SubtractionFactory;
import factory.SumFactory;
import calculator.Calculadora;

public class CalculatorFacade {
    private Controller individualSumController;
    private Controller individualSubtractionController;
    private Controller batchSumController;
    private Controller batchSubtractionController;
    private Controller batchSumArrayController;
    private Controller batchSubtractionArrayController;

    // Construtor para inicializar as fábricas e controladores
    public CalculatorFacade() {
        // Fábricas de cálculo
        CalculationFactory sumFactory = new SumFactory();
        CalculationFactory subtractionFactory = new SubtractionFactory();
        BatchCalculationFactory batchSumFactory = new BatchSumFactory();
        BatchCalculationFactory batchSubtractionFactory = new BatchSubtractionFactory();

        // Calculadoras
        Calculadora individualSumCalculator = new Calculadora(sumFactory);
        Calculadora individualSubtractionCalculator = new Calculadora(subtractionFactory);
        Calculadora batchSumCalculator = new Calculadora(batchSumFactory);
        Calculadora batchSubtractionCalculator = new Calculadora(batchSubtractionFactory);
        BatchCalculationAdapter batchSumCalculationAdapter = new BatchCalculationAdapterImpl(batchSumCalculator);
        BatchCalculationAdapter batchSubtractionCalculationAdapter = new BatchCalculationAdapterImpl(batchSubtractionCalculator);

        // Controladores
        this.individualSumController = new Controller(individualSumCalculator);
        this.individualSubtractionController = new Controller(individualSubtractionCalculator);
        this.batchSumController = new Controller(batchSumCalculator);
        this.batchSubtractionController = new Controller(batchSubtractionCalculator);
        this.batchSumArrayController = new Controller(batchSumCalculationAdapter);
        this.batchSubtractionArrayController = new Controller(batchSubtractionCalculationAdapter);
    }

    // Métodos para realizar cálculos individuais
    public double calculateIndividualSum(int value1, int value2) {
        individualSumController.performIndividualCalculation(value1, value2);
        return individualSumController.getResult();
    }

    public double calculateIndividualSubtraction(int value1, int value2) {
        individualSubtractionController.performIndividualCalculation(value1, value2);
        return individualSubtractionController.getResult();
    }

    // Métodos para realizar cálculos em lote usando string
    public double calculateBatchSum(String values) {
        batchSumController.performBatchCalculation(values);
        return batchSumController.getResult();
    }

    public double calculateBatchSubtraction(String values) {
        batchSubtractionController.performBatchCalculation(values);
        return batchSubtractionController.getResult();
    }

    // Métodos para realizar cálculos em lote usando vetor de inteiros
    public double calculateBatchSum(int[] values) {
        batchSumArrayController.performBatchCalculation(values);
        return batchSumArrayController.getResult();
    }

    public double calculateBatchSubtraction(int[] values) {
        batchSubtractionArrayController.performBatchCalculation(values);
        return batchSubtractionArrayController.getResult();
    }
}
