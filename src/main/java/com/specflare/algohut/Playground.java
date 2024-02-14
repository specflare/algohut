package com.specflare.algohut;

public class Playground {
    static class Obj {
        int a, b;
        Obj(int aa, int bb) {
            a = aa;
            b = bb;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", a, b);
        }
    }



    public static void main(String[] args) {
//        List<Obj> list = List.of(new Obj(1, 1),
//                new Obj(2, 2),
//                new Obj(3, 3),
//                new Obj(4, 4),
//                new Obj(5, 5));
//
//        list.forEach(elem -> {
//            elem.a += 100;
//            elem.b += 100;
//            throw new ArithmeticException("gigel!");
//        });
//
//        System.out.println(list);
    }
}
