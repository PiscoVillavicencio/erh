package pe.gob.minsa.erh.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum PerfilEnum {

    DESCONOCIDO(0, "DESCONOCIDO"),
    DIRECTOR(1, "Director"),
    MEDICO(2, "Medico"),
    PACIENTE(3, "Paciente"),
    CUIDADOR(4, "Cuidador"),
    ;

    private Integer code;
    private String label;

    PerfilEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<PerfilEnum> findAll() {
        List<PerfilEnum> list = new ArrayList<PerfilEnum>();

        for (PerfilEnum status : PerfilEnum.values()) {
            list.add(status);
        }
        return list;
    }

    public static PerfilEnum findByCode(Integer code) {
        PerfilEnum[] array = PerfilEnum.values();
        PerfilEnum result = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getCode() == code) {
                result = array[i];
                break;
            }
        }
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
