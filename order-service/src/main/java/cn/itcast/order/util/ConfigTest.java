package cn.itcast.order.util;

import org.junit.jupiter.api.Test;
import org.pkl.config.java.Config;
import org.pkl.config.java.ConfigEvaluator;
import org.pkl.core.PObject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.pkl.core.ModuleSource.text;

public class ConfigTest {
    private final ConfigEvaluator evaluator = ConfigEvaluator.preconfigured();

    private final Config pigeonConfig =
            evaluator.evaluate(
                    text(
                            "<Data>\n" +
                                    "<T_POHEAD>\n" +
                                    "<AUFNR>1542433</AUFNR>\n" +
                                    "<DOFLAG>X</DOFLAG>\n" +
                                    "<STAT></STAT>\n" +
                                    "<PSMNG></PSMNG>\n" +
                                    "<ERPADD>\n" +
                                    "<ADDIT1></ADDIT1>\n" +
                                    "<ADDIT2></ADDIT2>\n" +
                                    "<ADDIT3></ADDIT3>\n" +
                                    "<ADDIT4></ADDIT4>\n" +
                                    "<ADDIT5></ADDIT5>\n" +
                                    "</ERPADD>\n" +
                                    "</T_POHEAD>\n" +
                                    "<T_POITEM>\n" +
                                    "<AUFNR>1542433</AUFNR>\n" +
                                    "<DOFLAG>X</DOFLAG>\n" +
                                    "<RSPOS></RSPOS>\n" +
                                    "<POSNR>9010</POSNR>\n" +
                                    "<MATNR>YL0000502</MATNR>\n" +
                                    "<MEINS></MEINS>\n" +
                                    "<BDMNG>81.0</BDMNG>\n" +
                                    "<LGORT></LGORT>\n" +
                                    "<RGEKZ>X</RGEKZ>\n" +
                                    "<SCHGT></SCHGT>\n" +
                                    "<DUMPS></DUMPS>\n" +
                                    "<KZKUP></KZKUP>\n" +
                                    "<ERPADD>\n" +
                                    "<ADDIT1></ADDIT1>\n" +
                                    "<ADDIT2>3002</ADDIT2>\n" +
                                    "<ADDIT3></ADDIT3>\n" +
                                    "<ADDIT4></ADDIT4>\n" +
                                    "<ADDIT5></ADDIT5>\n" +
                                    "</ERPADD>\n" +
                                    "</T_POITEM>\n" +
                                    "<T_POITEM>\n" +
                                    "<AUFNR>1542433</AUFNR>\n" +
                                    "<DOFLAG>D</DOFLAG>\n" +
                                    "<RSPOS>8</RSPOS>\n" +
                                    "<POSNR>80</POSNR>\n" +
                                    "<MATNR></MATNR>\n" +
                                    "<MEINS></MEINS>\n" +
                                    "<BDMNG>0.0</BDMNG>\n" +
                                    "<LGORT></LGORT>\n" +
                                    "<RGEKZ></RGEKZ>\n" +
                                    "<SCHGT></SCHGT>\n" +
                                    "<DUMPS></DUMPS>\n" +
                                    "<KZKUP></KZKUP>\n" +
                                    "<ERPADD>\n" +
                                    "<ADDIT1></ADDIT1>\n" +
                                    "<ADDIT2>3002</ADDIT2>\n" +
                                    "<ADDIT3></ADDIT3>\n" +
                                    "<ADDIT4></ADDIT4>\n" +
                                    "<ADDIT5></ADDIT5>\n" +
                                    "</ERPADD>\n" +
                                    "</T_POITEM>\n" +
                                    "</Data>"));

    private final Config pigeonModuleConfig =
            evaluator.evaluate(
                    text("age = 30; friends = List(\"john\", \"mary\"); address { street = \"Fuzzy St.\" }"));

    private final Config pairConfig =
            evaluator.evaluate(text("x { first = \"file/path\"; second = 42 }"));

    private final Config mapConfig = evaluator.evaluate(text("x = Map(\"one\", 1, \"two\", 2)"));
    @Test
    public void navigate() {
        Config pigeon = pigeonConfig.get("Data");
        //pigeon.getRawValue()
        assertThat(pigeon.getQualifiedName()).isEqualTo("Data");
        assertThat(pigeon.getRawValue()).isInstanceOf(PObject.class);


        Config address = pigeon.get("RGEKZ");
        assertThat(address.getQualifiedName()).isEqualTo("Data.RGEKZ");
        assertThat(address.getRawValue()).isInstanceOf(PObject.class);

        /*Config street = address.get("street");
        assertThat(street.getQualifiedName()).isEqualTo("pigeon.address.street");
        assertThat(street.getRawValue()).isInstanceOf(String.class);

        assertThat(street.as(String.class)).isEqualTo("Fuzzy St.");*/
    }

}
