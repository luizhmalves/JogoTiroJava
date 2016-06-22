/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

/**
 *
 * @author luiz
 */
public class MyClassLoader extends ClassLoader {

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }
    public Class loadClass(String name) throws ClassNotFoundException{
        return super.loadClass(name);
    }

   /* @Override
    public Class loadClass(String name) throws ClassNotFoundException {

        if (!"Municao".equals(name)) {

            return super.loadClass(name);
        }
        try {
        String url = "src/jogotiro/municaoNivel2/Municao.java";
        URL minhaUrl = new URL(url);
        URLConnection conexao = minhaUrl.openConnection();
        InputStream entrada = conexao.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int dado = entrada.read();
        
        while(dado != -1){
            buffer.write(dado);
            dado = entrada.read();
        }
        entrada.close();
        
        byte[] classeDado = buffer.toByteArray();
        
        return defineClass("Municao",classeDado,0,classeDado.length);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MyClassLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyClassLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
}
