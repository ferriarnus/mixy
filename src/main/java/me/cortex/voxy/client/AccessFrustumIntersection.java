package me.cortex.voxy.client;
import org.joml.FrustumIntersection;
import org.joml.Vector4f;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;

public class AccessFrustumIntersection {
    private static final VarHandle planesHandle;
    static {
        try {
            final Field planesField = FrustumIntersection.class.getDeclaredField("planes");
            planesField.setAccessible(true);
            planesHandle = MethodHandles.privateLookupIn(FrustumIntersection.class, MethodHandles.lookup()).unreflectVarHandle(planesField);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static Vector4f[] getPlanes(FrustumIntersection fi) {
        return (Vector4f[]) planesHandle.get(fi);
    }
}
