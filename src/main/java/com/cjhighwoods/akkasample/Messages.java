package com.cjhighwoods.akkasample;

import java.io.Serializable;

public class Messages {

    public static class Operation implements Serializable {
        private static final long serialVersionUID = 2840334250108933392L;
        
        int left;
        int right;

        public Operation(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static class Add extends Operation {
        private static final long serialVersionUID = 3819896155342614140L;

        public Add(int left, int right) {
            super(left, right);
        }

        public String toString() {
            return String.format("%d + %d", left, right);
        }
    }

    public static class Multiply extends Operation {
        private static final long serialVersionUID = 8846577551096365644L;

        public Multiply(int left, int right) {
            super(left, right);
        }

        public String toString() {
            return String.format("%d * %d", left, right);
        }
    }

    public static class CalcResult implements Serializable {
        private static final long serialVersionUID = 6027949110132897066L;
        
        Operation op;
        int result;

        public CalcResult(Operation op, int result) {
            this.op = op;
            this.result = result;
        }

        public String toString() {
            return String.format("%s = %d", op.toString(), result);
        }
    }
}
