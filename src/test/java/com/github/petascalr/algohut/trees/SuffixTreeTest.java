package com.github.petascalr.algohut.trees;

import org.junit.Test;

public class SuffixTreeTest {

    @Test
    public void basicTest() {
        String str = "HAVANABANANA";

        SuffixTree st = new SuffixTree();
        st.T = str.toCharArray();
        st.N = st.T.length - 1;

        for (int i = 0; i <= st.N; i++)
            st.AddPrefix(st.active, i);

        st.dump_edges(st.N);


        final String DELOITTE = new String("Deloitte");
        String s1 = "Deloitte";
        String s2 = new String(s1);
        String s3 = new String("Deloitte");
        String s4 = "Deloitte";
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1==s4);
        System.out.println(s1==DELOITTE);
        System.out.println(s2==DELOITTE);
        System.out.println(s3==DELOITTE);

    }
}
