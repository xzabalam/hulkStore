package todouno.hulk.store.web.rest.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public final class UtilRest {
    
    private static final String UTF8 = "UTF-8";
    private static final String CODIFICACION_INCORRECTA = "El parámetro ingresado no tiene la codificación correcta.";
    
    public static String decodeBase64(final String encodeString) throws UnsupportedEncodingException {
        final byte[] decodedByte = Base64.decodeBase64(encodeString);
        return new String(decodedByte, UTF8).toString();
    }
    
    public static String decodeJsonBase64(final String json) throws UnsupportedEncodingException {
        if (Base64.isBase64(json)) {
            final String urlEncode = decodeBase64(json);
            return URLDecoder.decode(urlEncode, UTF8);
        } else {
            throw new UnsupportedEncodingException(CODIFICACION_INCORRECTA);
        }
    }
    
    public static String getJsonRequest(final String json, final String nombreParametro) {
        final JsonObject entradas = new Gson().fromJson(json, JsonObject.class);
        return entradas.get(nombreParametro).getAsString();
    }
    
    public static <T> T jsonToDto(final String json, final Class<T> dto) {
        return new Gson().fromJson(json, dto);
    }
    
    /**
     *
     */
    private UtilRest() {
        super();
    }
}
