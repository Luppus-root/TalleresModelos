package com.modelos.creacionalestructural.adapters;

public class AdapterStringInt implements InterfaceStringInt {

        @Override
        public int convertir(String s) {

            return Integer.parseInt(s);
        }

    }