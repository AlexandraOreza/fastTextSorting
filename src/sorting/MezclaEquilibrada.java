/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Alexandra
 */
public class MezclaEquilibrada {

    public void ordenamiento(String fpath) {
        try {
            File f= new File(fpath);
            File f1 = new File("src/resources/F1.txt");
            File f2 = new File("src/resources/F2.txt");
            File f3 = new File("src/resources/F3.txt");
            particion_inicial(f, f2, f3);
            particion_fusion(f2, f3, f, f1);

            BufferedReader f1Reader = new BufferedReader(new FileReader(f1));
            String f1Line = f1Reader.readLine();

            BufferedReader f3Reader = new BufferedReader(new FileReader(f3));
            String f3Line = f3Reader.readLine();

            boolean BAND = true;

            do {
                if (BAND == true) {
                    particion_fusion(f2, f3, f, f1);
                    BAND = false;
                } else {
                    particion_fusion(f, f1, f2, f3);
                    BAND = true;
                }

                f1Line = f1Reader.readLine();
                f3Line = f3Reader.readLine();
            } while (f1Line != null || f3Line != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void particion_inicial(File f, File f2, File f3) {
        try {
            Scanner F = new Scanner(f);

            PrintStream F2 = new PrintStream(f2);
            PrintStream F3 = new PrintStream(f3);

            String R = F.next();
            F2.println(R);
            boolean BAND = true;
            String AUX = R;

            while (F.hasNext()) {
                R = F.next();
                int nR = Integer.parseInt(R);
                int nAUX = Integer.parseInt(AUX);

                if (nR >= nAUX) {
                    AUX = R;

                    if (BAND == true) {
                        F2.println(R);
                    } else {
                        F3.println(R);
                    }
                } else {
                    AUX = R;

                    if (BAND == true) {
                        F3.println(R);
                        BAND = false;
                    } else {
                        F2.println(R);
                        BAND = true;
                    }
                }
            }

            F.close();
            F2.close();
            F3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void particion_fusion(File fa, File fb, File fc, File fd) {
        try {
            Scanner FA = new Scanner(fa);
            Scanner FB = new Scanner(fb);

            PrintStream FC = new PrintStream(fc);
            PrintStream FD = new PrintStream(fd);

            boolean BAN1 = true;
            boolean BAN2 = true;
            boolean BAN3 = true;

            int AUX = 0;

            String R1 = "";
            String R2 = "";

            while ((FA.hasNext() || BAN1 == false) && (FB.hasNext() || BAN2 == false)) {
                if (BAN1 == true) {
                    R1 = FA.next();
                    BAN1 = false;
                }
                if (BAN2 == true) {
                    R2 = FB.next();
                    BAN2 = false;
                }

                int nR1 = Integer.parseInt(R1);
                int nR2 = Integer.parseInt(R2);

                if (nR1 < nR2) {
                    if (nR1 >= AUX) {
                        if (BAN3 == true) {
                            FC.println(R1);
                        } else {
                            FD.println(R1);
                        }

                        BAN1 = true;
                        AUX = nR1;
                    } else {
                        if (BAN3 == true) {
                            FC.println(R2);
                            BAN3 = false;
                        } else {
                            FD.println(R2);
                            BAN3 = true;
                        }

                        BAN2 = true;
                        AUX = -32768;
                    }
                } else {
                    if (nR2 >= AUX) {
                        if (BAN3 == true) {
                            FC.println(R2);
                        } else {
                            FD.println(R2);
                        }

                        BAN2 = true;
                        AUX = nR2;
                    } else {
                        if (BAN3 == true) {
                            FC.println(R1);
                            BAN3 = false;
                        } else {
                            FD.println(R1);
                            BAN3 = true;
                        }

                        BAN1 = true;
                        AUX = -32768;
                    }
                }
            }

            if (BAN1 == false) {
                if (BAN3 == true) {
                    FC.println(R1);

                    while (FA.hasNext()) {
                        R1 = FA.next();
                        FC.println(R1);
                    }
                } else {
                    FD.println(R1);

                    while (FA.hasNext()) {
                        R1 = FA.next();
                        FD.println(R1);
                    }
                }
            }
            if (BAN2 == false) {
                if (BAN3 == true) {
                    FC.println(R2);

                    while (FB.hasNext()) {
                        R2 = FB.next();
                        FC.println(R2);
                    }
                } else {
                    FD.println(R2);

                    while (FB.hasNext()) {
                        R2 = FB.next();
                        FD.println(R2);
                    }
                }
            }

            FC.close();
            FD.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
