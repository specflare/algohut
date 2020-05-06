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
    }
}
