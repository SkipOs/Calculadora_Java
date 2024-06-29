// Importações necessárias para a classe Observable
package model;

import java.util.Observable;

// Declaração da classe abstrata Model, que estende Observable
public abstract class Model extends Observable {

    // Atributo protegido que armazenará o resultado do cálculo
    protected double result;

    // Construtor protegido para evitar instanciamento direto
    protected Model() {}

    // Método abstrato que deve ser implementado pelas subclasses para realizar o cálculo
    public abstract void calculate();

    // Getter para o resultado do cálculo
    public double getResult() {
        return result;
    }

    // Setter para o resultado do cálculo, notificando os observadores sobre a mudança
    protected void setResult(double result) {
        this.result = result;
        setChanged();
        notifyObservers(result);
    }

    // Classe Builder estática interna para construir instâncias de Model
    public static class Builder {
        private double initialValue;

        // Método para definir o valor inicial (opcional)
        public Builder withInitialValue(double initialValue) {
            this.initialValue = initialValue;
            return this;
        }

        // Método build para criar uma instância da subclasse especificada
        public Model build(Class<? extends Model> modelClass) throws InstantiationException, IllegalAccessException {
			Model model = modelClass.newInstance();
            model.result = this.initialValue;
            return model;
        }
    }
}
