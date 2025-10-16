package org.example.java.designpattern.creational.builder;


class Pizza {

    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;

    // Private constructor (only Builder can create)
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.bacon = builder.bacon;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", bacon=" + bacon + "]";
    }

    public static class Builder{
        private String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean bacon;

        public Builder(String size){
            this.size = size;
        }
        public Builder addCheese(){
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni(){
            this.pepperoni = true;
            return this;
        }

        public Builder addBacon(){
            this.bacon = true;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }
}
