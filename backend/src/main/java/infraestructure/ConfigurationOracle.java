/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infraestructure;

/**
 *
 * @author Leo
 */
public class ConfigurationOracle {

    //utilizar variables de entorno para produccion
    public static final String ORACLE_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    public static final String ORACLE_USER = "test";
    public static final String ORACLE_PASSWORD = "test";
}
