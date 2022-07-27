package org.bone.springcloud.usuarios;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuariosApplicationTests {

    public class Hola {
        private String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }

    public Hola get() {
        Hola hola = new Hola();
        hola.setA("ad");
        return hola;
    }

    @Test
    void contextLoads() {
        Hola ob = null;
        ob = get();
        System.out.println(ob.getA());
    }

}
