/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sorting;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandra
 */
public class MezclaN {

    private boolean band;
    private String aux;

    public void MezclaNatural(String Fstring) {
        File F = new File(Fstring);
        File f1 = new File("src/resources/F1.txt");
        File f2 = new File("src/resources/F2.txt");
        File f3 = new File("src/resources/F3.txt");
        PartInicial(F, f2, f3);
        band = true;
        do {
            if (band) {
                PartFusion(f2, f3, F, f1);
                band = false;
            } else {
                PartFusion(F, f1, f2, f3);
                band = true;
            }

        } while (f1.length() != 0 || f3.length() != 0);

    }

    public void PartInicial(File F, File F2, File F3) {
        try {
            String r;
            boolean band;
            BufferedReader file = new BufferedReader(new FileReader(F));
            BufferedWriter escritura2 = null, escritura3 = null;
            escritura2 = new BufferedWriter(new FileWriter(F2));
            escritura3 = new BufferedWriter(new FileWriter(F3));

            r = file.readLine();
            escritura2.write(r + "\n");
            band = true;
            aux = r;
            while (r != null) {
                r = file.readLine();
                System.out.println(r);
                //r >= aux
                if (r != null) {
                    if (r.compareTo(aux) >= 0) {
                        aux = r;
                        if (band) {
                            escritura2.write(r + "\n");
                        } else {
                            escritura3.write(r + "\n");
                        }
                    } else {
                        aux = r;
                        if (band) {
                            escritura3.write(r + "\n");
                            band = false;
                        } else {
                            escritura2.write(r + "\n");
                            band = true;
                        }

                    }
                }
            }

            file.close();
            escritura2.close();
            escritura3.close();
        } catch (IOException ex) {
            Logger.getLogger(MezclaN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PartFusion(File F, File F1, File F2, File F3) {
        try {
            String r1, r2;
            boolean band, del1, del2;
            BufferedReader file = new BufferedReader(new FileReader(F));
            BufferedReader file1 = new BufferedReader(new FileReader(F1));

            BufferedWriter escritura2 = null, escritura3 = null;
            escritura2 = new BufferedWriter(new FileWriter(F2));
            escritura3 = new BufferedWriter(new FileWriter(F3));

            band = true;
            r1 = file.readLine();
            r2 = file1.readLine();

            //r1 < r2
            if (r1 != null && r2 != null) {
                if (r1.compareTo(r2) < 0) {
                    aux = r1;
                } else {
                    aux = r2;
                }
            }

            del1 = false;
            del2 = false;
            while ((r1 != null || del1) && (r2 != null || del2)) {
                if (del1) {
                    r1 = file.readLine();
                    del1 = false;
                }
                if (del2) {
                    r2 = file1.readLine();
                    del2 = false;
                }

                //r1 < r2
                if (r1 != null && r2 != null) {
                    if (r1.compareTo(r2) < 0) {
                        //r1 > aux
                        if (r1.compareTo(aux) > 0) {
                            Ayuda1(r1, escritura2, escritura3, band);
                            del1 = true;
                        } else {
                            //r2 > aux
                            if (r2.compareTo(aux) > 0) {
                                Ayuda1(r2, escritura2, escritura3, band);
                                del2 = true;
                            } else {
                                Ayuda2(r1, escritura2, escritura3, band);
                                del1 = true;
                            }
                        }
                    } else {
                        //r2 > aux
                        if (r2.compareTo(aux) > 0) {
                            Ayuda1(r2, escritura2, escritura3, band);
                            del2 = true;
                        } else {
                            if (r1.compareTo(aux) > 0) {
                                Ayuda1(r1, escritura2, escritura3, band);
                                del1 = true;
                            } else {
                                Ayuda2(r2, escritura2, escritura3, band);
                                del2 = true;
                            }
                        }
                    }
                }

            }

            if (del1 && r1 == null) {
                Ayuda3(r2, F1, escritura2, escritura3, band);
            }

            if (del2 && r2 == null) {
                Ayuda3(r1, F, escritura2, escritura3, band);
            }

            file.close();
            file1.close();
            escritura2.close();
            escritura3.close();
        } catch (IOException ex) {
            Logger.getLogger(MezclaN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Ayuda1(String r, BufferedWriter escritura2, BufferedWriter escritura3, boolean band) {
        try {
            if (band) {
                escritura2.write(r + "\n");
            } else {
                escritura3.write(r + "\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(MezclaN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Ayuda2(String r, BufferedWriter escritura2, BufferedWriter escritura3, boolean band) {
        try {
            if (band) {
                escritura2.write(r + "\n");
                band = false;
            } else {
                escritura3.write(r + "\n");
                band = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(MezclaN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Ayuda3(String r, File F, BufferedWriter escritura2, BufferedWriter escritura3, boolean band) {
        if (r.compareTo(aux) > 0) {
            Ayuda1(r, escritura2, escritura3, band);
        } else {
            Ayuda2(r, escritura2, escritura3, band);
        }
        try {
            BufferedReader file = new BufferedReader(new FileReader(F));
            while (r != null) {
                r = file.readLine();
                if (r != null) {
                    if (r.compareTo(aux) > 0) {
                        Ayuda1(r, escritura2, escritura3, band);
                    } else {
                        Ayuda2(r, escritura2, escritura3, band);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MezclaN.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
