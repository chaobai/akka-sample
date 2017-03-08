package com.cjhighwoods.akkasample;

import java.io.Serializable;

public class Messages implements Serializable {
    public static class Operation implements Serializable {
        int left;
        int right;
        public Operation(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    
    public static class Add extends Operation {
        public Add(int left, int right) {
            super(left, right);
        }

        public String toString() {
            return String.format("%d + %d", left, right);
        }
    }
    
    public static class Multiply extends Operation {
        public Multiply(int left, int right) {
            super(left, right);
        }

        public String toString() {
            return String.format("%d * %d", left, right);
        }
    }
    
    public static class CalcResult implements Serializable {
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
