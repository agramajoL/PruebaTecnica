/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Leo
 */
public enum GenerosPoesia {
    LIRICA("Lirica"),
    EPICO("Epico"),
    DRAMATICO("Dramatico");

    private final String _text;

    GenerosPoesia(final String text) {
        _text = text;
    }

    @Override
    public String toString() {
        return _text;
    }
}
