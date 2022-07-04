package com.evoxon.romans.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RomanConverterTest {

    private RomanConverter romanConverter = new RomanConverter();


    @Test
    void fromDecimalToRoman() {
        //given
        final int decimal1 = 41;
        final int decimal2 = 23;
        final int decimal3 = 56;
        final int decimal4 = 97;
        final int decimal5 = 105;
        final int decimal6 = 277;
        final int decimal7 = 975;
        final int decimal8 = 1029;
        final int decimal9 = 1760;
        final int decimal10 = 2222;
        //when
        final String roman1 = romanConverter.fromDecimalToRoman(decimal1);
        final String roman2 = romanConverter.fromDecimalToRoman(decimal2);
        final String roman3 = romanConverter.fromDecimalToRoman(decimal3);
        final String roman4 = romanConverter.fromDecimalToRoman(decimal4);
        final String roman5 = romanConverter.fromDecimalToRoman(decimal5);
        final String roman6 = romanConverter.fromDecimalToRoman(decimal6);
        final String roman7 = romanConverter.fromDecimalToRoman(decimal7);
        final String roman8 = romanConverter.fromDecimalToRoman(decimal8);
        final String roman9 = romanConverter.fromDecimalToRoman(decimal9);
        final String roman10 = romanConverter.fromDecimalToRoman(decimal10);
        //then
        assertThat(roman1).isEqualTo("XLI");
        assertThat(roman2).isEqualTo("XXIII");
        assertThat(roman3).isEqualTo("LVI");
        assertThat(roman4).isEqualTo("XCVII");
        assertThat(roman5).isEqualTo("CV");
        assertThat(roman6).isEqualTo("CCLXXVII");
        assertThat(roman7).isEqualTo("CMLXXV");
        assertThat(roman8).isEqualTo("MXXIX");
        assertThat(roman9).isEqualTo("MDCCLX");
        assertThat(roman10).isEqualTo("MMCCXXII");
    }

    @Test
    void fromRomanToDecimal() {
        //given
        final String roman1 = "XXXIII";
        final String roman2 = "XLI";
        final String roman3 = "IX";
        final String roman4 = "LXXXVIII";
        final String roman5 = "CLXIV";
        final String roman6 = "CCCXLV";
        final String roman7 = "DCCLXXVI";
        final String roman8 = "MXXXVII";
        final String roman9 = "MDCCCLX";
        final String roman10 = "MMCCCXLVI";
        //when
        final int decimal1 = romanConverter.fromRomanToDecimal(roman1);
        final int decimal2 = romanConverter.fromRomanToDecimal(roman2);
        final int decimal3 = romanConverter.fromRomanToDecimal(roman3);
        final int decimal4 = romanConverter.fromRomanToDecimal(roman4);
        final int decimal5 = romanConverter.fromRomanToDecimal(roman5);
        final int decimal6 = romanConverter.fromRomanToDecimal(roman6);
        final int decimal7 = romanConverter.fromRomanToDecimal(roman7);
        final int decimal8 = romanConverter.fromRomanToDecimal(roman8);
        final int decimal9 = romanConverter.fromRomanToDecimal(roman9);
        final int decimal10 = romanConverter.fromRomanToDecimal(roman10);
        //then
        assertThat(decimal1).isEqualTo(33);
        assertThat(decimal2).isEqualTo(41);
        assertThat(decimal3).isEqualTo(9);
        assertThat(decimal4).isEqualTo(88);
        assertThat(decimal5).isEqualTo(164);
        assertThat(decimal6).isEqualTo(345);
        assertThat(decimal7).isEqualTo(776);
        assertThat(decimal8).isEqualTo(1037);
        assertThat(decimal9).isEqualTo(1860);
        assertThat(decimal10).isEqualTo(2346);
    }

    @Test
    void incrementalTest(){
        int number = 1;
        for(int i=0; i<2000 ; i++){
            assertThat(romanConverter.fromRomanToDecimal(romanConverter.fromDecimalToRoman(number))).isEqualTo(number);
            number++;
        }
    }

    @Test
    void singleTest() {
        //given
        final int decimal1 = 5;
        final String roman1 = "V";
        assertThat(romanConverter.fromRomanToDecimal(roman1)).isEqualTo(decimal1);
        assertThat(romanConverter.fromDecimalToRoman(decimal1)).isEqualTo(roman1);

    }
}