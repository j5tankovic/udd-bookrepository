package com.bdzjn.udd.index.filters.stemming;

import org.tartarus.snowball.Among;
import org.tartarus.snowball.SnowballProgram;

import java.lang.invoke.MethodHandles;

public class SimpleSerbianStemmer extends SnowballProgram {

    private static final long serialVersionUID = 1L;

    private final static MethodHandles.Lookup methodObject = MethodHandles.lookup();

    private final static Among a_0[] = {
            new Among("daba", -1, 66, "", methodObject),
            new Among("ajaca", -1, 11, "", methodObject),
            new Among("ejaca", -1, 13, "", methodObject),
            new Among("ljaca", -1, 12, "", methodObject),
            new Among("njaca", -1, 78, "", methodObject),
            new Among("ojaca", -1, 14, "", methodObject),
            new Among("alaca", -1, 75, "", methodObject),
            new Among("elaca", -1, 76, "", methodObject),
            new Among("olaca", -1, 77, "", methodObject),
            new Among("maca", -1, 68, "", methodObject),
            new Among("naca", -1, 69, "", methodObject),
            new Among("raca", -1, 74, "", methodObject),
            new Among("saca", -1, 73, "", methodObject),
            new Among("vaca", -1, 72, "", methodObject),
            new Among("\u0161aca", -1, 17, "", methodObject),
            new Among("ajca", -1, 11, "", methodObject),
            new Among("ejca", -1, 13, "", methodObject),
            new Among("ljca", -1, 12, "", methodObject),
            new Among("ojca", -1, 14, "", methodObject),
            new Among("aoca", -1, 75, "", methodObject),
            new Among("\u0161ca", -1, 17, "", methodObject),
            new Among("loga", -1, 1, "", methodObject),
            new Among("acaka", -1, 51, "", methodObject),
            new Among("ajaka", -1, 15, "", methodObject),
            new Among("ojaka", -1, 16, "", methodObject),
            new Among("anaka", -1, 71, "", methodObject),
            new Among("ataka", -1, 53, "", methodObject),
            new Among("etaka", -1, 54, "", methodObject),
            new Among("itaka", -1, 55, "", methodObject),
            new Among("otaka", -1, 56, "", methodObject),
            new Among("utaka", -1, 57, "", methodObject),
            new Among("ojska", -1, 60, "", methodObject),
            new Among("esama", -1, 61, "", methodObject),
            new Among("izama", -1, 80, "", methodObject),
            new Among("cima", -1, 67, "", methodObject),
            new Among("jacima", 34, 5, "", methodObject),
            new Among("nicima", 34, 22, "", methodObject),
            new Among("ticima", 34, 23, "", methodObject),
            new Among("teticima", 37, 20, "", methodObject),
            new Among("zicima", 34, 24, "", methodObject),
            new Among("atcima", 34, 53, "", methodObject),
            new Among("utcima", 34, 57, "", methodObject),
            new Among("pesima", -1, 2, "", methodObject),
            new Among("inzima", -1, 18, "", methodObject),
            new Among("lozima", -1, 1, "", methodObject),
            new Among("metara", -1, 62, "", methodObject),
            new Among("centara", -1, 63, "", methodObject),
            new Among("istara", -1, 64, "", methodObject),
            new Among("ekata", -1, 79, "", methodObject),
            new Among("nstava", -1, 21, "", methodObject),
            new Among("kustava", -1, 28, "", methodObject),
            new Among("njac", -1, 78, "", methodObject),
            new Among("anjac", 51, 10, "", methodObject),
            new Among("alac", -1, 75, "", methodObject),
            new Among("elac", -1, 76, "", methodObject),
            new Among("olac", -1, 77, "", methodObject),
            new Among("mac", -1, 68, "", methodObject),
            new Among("nac", -1, 69, "", methodObject),
            new Among("rac", -1, 74, "", methodObject),
            new Among("sac", -1, 73, "", methodObject),
            new Among("vac", -1, 72, "", methodObject),
            new Among("jebe", -1, 81, "", methodObject),
            new Among("olce", -1, 77, "", methodObject),
            new Among("kuse", -1, 26, "", methodObject),
            new Among("rave", -1, 40, "", methodObject),
            new Among("\u0161ave", -1, 49, "", methodObject),
            new Among("ci", -1, 67, "", methodObject),
            new Among("baci", 66, 82, "", methodObject),
            new Among("jaci", 66, 5, "", methodObject),
            new Among("tvenici", 66, 19, "", methodObject),
            new Among("snici", 66, 25, "", methodObject),
            new Among("tetici", 66, 20, "", methodObject),
            new Among("bojci", 66, 4, "", methodObject),
            new Among("vojci", 66, 3, "", methodObject),
            new Among("atci", 66, 53, "", methodObject),
            new Among("itci", 66, 55, "", methodObject),
            new Among("utci", 66, 57, "", methodObject),
            new Among("cajni", -1, 6, "", methodObject),
            new Among("larni", -1, 8, "", methodObject),
            new Among("erni", -1, 7, "", methodObject),
            new Among("esni", -1, 9, "", methodObject),
            new Among("pesi", -1, 2, "", methodObject),
            new Among("inzi", -1, 18, "", methodObject),
            new Among("lozi", -1, 1, "", methodObject),
            new Among("acak", -1, 51, "", methodObject),
            new Among("atak", -1, 53, "", methodObject),
            new Among("etak", -1, 54, "", methodObject),
            new Among("itak", -1, 55, "", methodObject),
            new Among("otak", -1, 56, "", methodObject),
            new Among("utak", -1, 57, "", methodObject),
            new Among("u\u0161ak", -1, 52, "", methodObject),
            new Among("izam", -1, 80, "", methodObject),
            new Among("skom", -1, 84, "", methodObject),
            new Among("tican", -1, 59, "", methodObject),
            new Among("voljan", -1, 70, "", methodObject),
            new Among("eskan", -1, 58, "", methodObject),
            new Among("alan", -1, 38, "", methodObject),
            new Among("bilan", -1, 31, "", methodObject),
            new Among("gilan", -1, 35, "", methodObject),
            new Among("nilan", -1, 37, "", methodObject),
            new Among("rilan", -1, 36, "", methodObject),
            new Among("silan", -1, 34, "", methodObject),
            new Among("tilan", -1, 32, "", methodObject),
            new Among("avilan", -1, 33, "", methodObject),
            new Among("atan", -1, 45, "", methodObject),
            new Among("pletan", -1, 48, "", methodObject),
            new Among("tetan", -1, 47, "", methodObject),
            new Among("antan", -1, 30, "", methodObject),
            new Among("pravan", -1, 42, "", methodObject),
            new Among("stavan", -1, 41, "", methodObject),
            new Among("sivan", -1, 44, "", methodObject),
            new Among("tivan", -1, 43, "", methodObject),
            new Among("ozan", -1, 39, "", methodObject),
            new Among("a\u0161an", -1, 83, "", methodObject),
            new Among("du\u0161an", -1, 29, "", methodObject),
            new Among("kusin", -1, 27, "", methodObject),
            new Among("metar", -1, 62, "", methodObject),
            new Among("centar", -1, 63, "", methodObject),
            new Among("istar", -1, 64, "", methodObject),
            new Among("ekat", -1, 79, "", methodObject),
            new Among("anat", -1, 50, "", methodObject),
            new Among("enat", -1, 46, "", methodObject),
            new Among("o\u0161cu", -1, 65, "", methodObject),
            new Among("i\u0161tu", -1, 85, "", methodObject) };

    private static final char g_v[] = { 17, 65, 16 };

    private static final char g_sa[] = { 65, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,
            0, 0, 128 };

    private static final char g_ca[] = { 119, 95, 23, 1, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 136, 0, 0, 0, 0, 0, 0, 0, 0, 0, 128,
            0, 0, 0, 16 };

    private int I_p1;

    private void copy_from(SimpleSerbianStemmer other) {
        I_p1 = other.I_p1;
        super.copy_from(other);
    }

    private boolean r_prelude() {
        int v_1;
        int v_2;
        int v_3;
        int v_4;
        int v_5;
        int v_6;
        // (, line 36
        // do, line 38
        v_1 = cursor;
        lab0: do {
            // repeat, line 38
            replab1: while (true) {
                v_2 = cursor;
                lab2: do {
                    // goto, line 38
                    golab3: while (true) {
                        v_3 = cursor;
                        lab4: do {
                            // (, line 38
                            if (!(in_grouping(g_ca, 98, 382))) {
                                break lab4;
                            }
                            // [, line 39
                            bra = cursor;
                            // literal, line 39
                            if (!(eq_s(3, "ije"))) {
                                break lab4;
                            }
                            // ], line 39
                            ket = cursor;
                            if (!(in_grouping(g_ca, 98, 382))) {
                                break lab4;
                            }
                            // <-, line 39
                            slice_from("e");
                            cursor = v_3;
                            break golab3;
                        } while (false);
                        cursor = v_3;
                        if (cursor >= limit) {
                            break lab2;
                        }
                        cursor++;
                    }
                    continue replab1;
                } while (false);
                cursor = v_2;
                break replab1;
            }
        } while (false);
        cursor = v_1;
        // do, line 42
        v_4 = cursor;
        lab5: do {
            // repeat, line 42
            replab6: while (true) {
                v_5 = cursor;
                lab7: do {
                    // goto, line 42
                    golab8: while (true) {
                        v_6 = cursor;
                        lab9: do {
                            // (, line 42
                            if (!(in_grouping(g_ca, 98, 382))) {
                                break lab9;
                            }
                            // [, line 43
                            bra = cursor;
                            // literal, line 43
                            if (!(eq_s(2, "je"))) {
                                break lab9;
                            }
                            // ], line 43
                            ket = cursor;
                            if (!(in_grouping(g_ca, 98, 382))) {
                                break lab9;
                            }
                            // <-, line 43
                            slice_from("e");
                            cursor = v_6;
                            break golab8;
                        } while (false);
                        cursor = v_6;
                        if (cursor >= limit) {
                            break lab7;
                        }
                        cursor++;
                    }
                    continue replab6;
                } while (false);
                cursor = v_5;
                break replab6;
            }
        } while (false);
        cursor = v_4;
        return true;
    }

    private boolean r_mark_regions() {
        // (, line 47
        I_p1 = limit;
        // gopast, line 51
        golab0: while (true) {
            lab1: do {
                if (!(in_grouping(g_v, 97, 117))) {
                    break lab1;
                }
                break golab0;
            } while (false);
            if (cursor >= limit) {
                return false;
            }
            cursor++;
        }
        // gopast, line 51
        golab2: while (true) {
            lab3: do {
                if (!(out_grouping(g_v, 97, 117))) {
                    break lab3;
                }
                break golab2;
            } while (false);
            if (cursor >= limit) {
                return false;
            }
            cursor++;
        }
        // setmark p1, line 51
        I_p1 = cursor;
        return true;
    }

    private boolean r_R1() {
        if (!(I_p1 <= cursor)) {
            return false;
        }
        return true;
    }

    private boolean r_Step_1() {
        int among_var;
        // (, line 59
        // [, line 60
        ket = cursor;
        // substring, line 60
        among_var = find_among_b(a_0, 124);
        if (among_var == 0) {
            return false;
        }
        // ], line 60
        bra = cursor;
        // call R1, line 61
        if (!r_R1()) {
            return false;
        }
        switch (among_var) {
            case 0:
                return false;
            case 1:
                // (, line 65
                // <-, line 65
                slice_from("log");
                break;
            case 2:
                // (, line 67
                // <-, line 67
                slice_from("peh");
                break;
            case 3:
                // (, line 68
                // <-, line 68
                slice_from("vojka");
                break;
            case 4:
                // (, line 69
                // <-, line 69
                slice_from("bojka");
                break;
            case 5:
                // (, line 71
                // <-, line 71
                slice_from("jak");
                break;
            case 6:
                // (, line 72
                // <-, line 72
                slice_from("cajan");
                break;
            case 7:
                // (, line 73
                // <-, line 73
                slice_from("eran");
                break;
            case 8:
                // (, line 74
                // <-, line 74
                slice_from("laran");
                break;
            case 9:
                // (, line 75
                // <-, line 75
                slice_from("esan");
                break;
            case 10:
                // (, line 76
                // <-, line 76
                slice_from("anjca");
                break;
            case 11:
                // (, line 78
                // <-, line 78
                slice_from("ajca");
                break;
            case 12:
                // (, line 80
                // <-, line 80
                slice_from("ljac");
                break;
            case 13:
                // (, line 82
                // <-, line 82
                slice_from("ejca");
                break;
            case 14:
                // (, line 84
                // <-, line 84
                slice_from("ojac");
                break;
            case 15:
                // (, line 85
                // <-, line 85
                slice_from("ajka");
                break;
            case 16:
                // (, line 86
                // <-, line 86
                slice_from("ojka");
                break;
            case 17:
                // (, line 88
                // <-, line 88
                slice_from("\u0161ac");
                break;
            case 18:
                // (, line 90
                // <-, line 90
                slice_from("ing");
                break;
            case 19:
                // (, line 91
                // <-, line 91
                slice_from("tvenik");
                break;
            case 20:
                // (, line 93
                // <-, line 93
                slice_from("tetika");
                break;
            case 21:
                // (, line 94
                // <-, line 94
                slice_from("nstvo");
                break;
            case 22:
                // (, line 95
                // <-, line 95
                slice_from("nik");
                break;
            case 23:
                // (, line 96
                // <-, line 96
                slice_from("tik");
                break;
            case 24:
                // (, line 97
                // <-, line 97
                slice_from("zik");
                break;
            case 25:
                // (, line 98
                // <-, line 98
                slice_from("snik");
                break;
            case 26:
                // (, line 99
                // <-, line 99
                slice_from("kusi");
                break;
            case 27:
                // (, line 100
                // <-, line 100
                slice_from("kusan");
                break;
            case 28:
                // (, line 101
                // <-, line 101
                slice_from("kustvo");
                break;
            case 29:
                // (, line 102
                // <-, line 102
                slice_from("du\u0161ni");
                break;
            case 30:
                // (, line 103
                // <-, line 103
                slice_from("antni");
                break;
            case 31:
                // (, line 104
                // <-, line 104
                slice_from("bilni");
                break;
            case 32:
                // (, line 105
                // <-, line 105
                slice_from("tilni");
                break;
            case 33:
                // (, line 106
                // <-, line 106
                slice_from("avilni");
                break;
            case 34:
                // (, line 107
                // <-, line 107
                slice_from("silni");
                break;
            case 35:
                // (, line 108
                // <-, line 108
                slice_from("gilni");
                break;
            case 36:
                // (, line 109
                // <-, line 109
                slice_from("rilni");
                break;
            case 37:
                // (, line 110
                // <-, line 110
                slice_from("nilni");
                break;
            case 38:
                // (, line 111
                // <-, line 111
                slice_from("alni");
                break;
            case 39:
                // (, line 112
                // <-, line 112
                slice_from("ozni");
                break;
            case 40:
                // (, line 113
                // <-, line 113
                slice_from("ravi");
                break;
            case 41:
                // (, line 114
                // <-, line 114
                slice_from("stavni");
                break;
            case 42:
                // (, line 115
                // <-, line 115
                slice_from("pravni");
                break;
            case 43:
                // (, line 116
                // <-, line 116
                slice_from("tivni");
                break;
            case 44:
                // (, line 117
                // <-, line 117
                slice_from("sivni");
                break;
            case 45:
                // (, line 118
                // <-, line 118
                slice_from("atni");
                break;
            case 46:
                // (, line 119
                // <-, line 119
                slice_from("enta");
                break;
            case 47:
                // (, line 120
                // <-, line 120
                slice_from("tetni");
                break;
            case 48:
                // (, line 121
                // <-, line 121
                slice_from("pletni");
                break;
            case 49:
                // (, line 122
                // <-, line 122
                slice_from("\u0161avi");
                break;
            case 50:
                // (, line 123
                // <-, line 123
                slice_from("anta");
                break;
            case 51:
                // (, line 125
                // <-, line 125
                slice_from("acka");
                break;
            case 52:
                // (, line 126
                // <-, line 126
                slice_from("u\u0161ka");
                break;
            case 53:
                // (, line 130
                // <-, line 130
                slice_from("atka");
                break;
            case 54:
                // (, line 132
                // <-, line 132
                slice_from("etka");
                break;
            case 55:
                // (, line 135
                // <-, line 135
                slice_from("itka");
                break;
            case 56:
                // (, line 137
                // <-, line 137
                slice_from("otka");
                break;
            case 57:
                // (, line 141
                // <-, line 141
                slice_from("utka");
                break;
            case 58:
                // (, line 142
                // <-, line 142
                slice_from("eskna");
                break;
            case 59:
                // (, line 143
                // <-, line 143
                slice_from("ticni");
                break;
            case 60:
                // (, line 144
                // <-, line 144
                slice_from("ojsci");
                break;
            case 61:
                // (, line 145
                // <-, line 145
                slice_from("esma");
                break;
            case 62:
                // (, line 147
                // <-, line 147
                slice_from("metra");
                break;
            case 63:
                // (, line 149
                // <-, line 149
                slice_from("centra");
                break;
            case 64:
                // (, line 151
                // <-, line 151
                slice_from("istra");
                break;
            case 65:
                // (, line 152
                // <-, line 152
                slice_from("o\u0161ti");
                break;
            case 66:
                // (, line 153
                // <-, line 153
                slice_from("dba");
                break;
            case 67:
                // (, line 155
                // <-, line 155
                slice_from("cka");
                break;
            case 68:
                // (, line 157
                // <-, line 157
                slice_from("mca");
                break;
            case 69:
                // (, line 159
                // <-, line 159
                slice_from("nca");
                break;
            case 70:
                // (, line 160
                // <-, line 160
                slice_from("voljni");
                break;
            case 71:
                // (, line 161
                // <-, line 161
                slice_from("anki");
                break;
            case 72:
                // (, line 163
                // <-, line 163
                slice_from("vca");
                break;
            case 73:
                // (, line 165
                // <-, line 165
                slice_from("sca");
                break;
            case 74:
                // (, line 167
                // <-, line 167
                slice_from("rca");
                break;
            case 75:
                // (, line 170
                // <-, line 170
                slice_from("alca");
                break;
            case 76:
                // (, line 172
                // <-, line 172
                slice_from("elca");
                break;
            case 77:
                // (, line 175
                // <-, line 175
                slice_from("olca");
                break;
            case 78:
                // (, line 177
                // <-, line 177
                slice_from("njca");
                break;
            case 79:
                // (, line 179
                // <-, line 179
                slice_from("ekta");
                break;
            case 80:
                // (, line 181
                // <-, line 181
                slice_from("izma");
                break;
            case 81:
                // (, line 182
                // <-, line 182
                slice_from("jebi");
                break;
            case 82:
                // (, line 183
                // <-, line 183
                slice_from("baci");
                break;
            case 83:
                // (, line 184
                // <-, line 184
                slice_from("a\u0161ni");
                break;
            case 84:
                // (, line 185
                // <-, line 185
                slice_from("sko");
                break;
            case 85:
                // (, line 186
                // <-, line 186
                slice_from("i\u0161te");
                break;
        }
        return true;
    }

    public boolean stem() {
        int v_1;
        int v_2;
        int v_3;
        // (, line 192
        // do, line 193
        v_1 = cursor;
        lab0: do {
            // call prelude, line 193
            if (!r_prelude()) {
                break lab0;
            }
        } while (false);
        cursor = v_1;
        // do, line 194
        v_2 = cursor;
        lab1: do {
            // call mark_regions, line 194
            if (!r_mark_regions()) {
                break lab1;
            }
        } while (false);
        cursor = v_2;
        // backwards, line 195
        limit_backward = cursor;
        cursor = limit;
        // (, line 195
        // do, line 196
        v_3 = limit - cursor;
        lab2: do {
            // call Step_1, line 196
            if (!r_Step_1()) {
                break lab2;
            }
        } while (false);
        cursor = limit - v_3;
        cursor = limit_backward;
        return true;
    }

    public boolean equals(Object o) {
        return o instanceof SimpleSerbianStemmer;
    }

    public int hashCode() {
        return SimpleSerbianStemmer.class.getName().hashCode();
    }

}
