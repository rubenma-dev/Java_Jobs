
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Simon
 */
public class Personas extends javax.swing.JInternalFrame {
    
    Connection coneccionsql;
    Statement sentenciasql;
    DefaultTableModel modelo_tabla;
    Integer id_persona;
    public static Integer id_pais;

    /**
     * Creates new form Personas
     */
    public Personas() {
        initComponents();
        coneccionsql = Conectar.getConnection();
        llenarTablar("");
        CargarPaises();
    }
    
    // Convertir Util.Date a sql.date
    //--------------------------------------------------------------------------
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
    
     void CargarPaises() {
        try {
            String stsql = "select * from pais order by nombre";
            sentenciasql = coneccionsql.createStatement();
            ResultSet rs = sentenciasql.executeQuery(stsql);
            while (rs.next()) {
                 comboPaises.addItem(rs.getString("nombre"));
            }
            rs.close();
        } catch (Exception e) {
            System.err.println("ERROR AL INTENTAR LISTAR LOS PAISES:" + e);
        }
    }
    
    
    public void llenarTablar(String filtro) {
        try {
            //encabezados de la tabla
            String[] titulos = {"ID", "Cedula", "Nombre", "Fecha Nac.", "Pais"};
            
            //TODOS
            String stsql = "SELECT persona.id, persona.cedula, persona.nombre, persona.fecha_nacimiento, pais.nombre AS pais \n" +
            "FROM persona\n" +
            "JOIN pais ON pais.id = persona.id_pais";
            
            //NOMBRE
            if (filtro.equals("Nombre")) {
                String nombre = campoFiltro.getText();
                stsql = "SELECT persona.id, persona.cedula, persona.nombre, persona.fecha_nacimiento, pais.nombre AS pais \n" +
                "FROM persona\n" +
                "JOIN pais ON pais.id = persona.id_pais\n"+
                "WHERE persona.nombre LIKE '%"+nombre+"%'";
            }
            
            //CEDULA
            if (filtro.equals("Cedula")) {
                String cedula = campoFiltro.getText();
                stsql = "SELECT persona.id, persona.cedula, persona.nombre, persona.fecha_nacimiento, pais.nombre AS pais \n" +
                "FROM persona\n" +
                "JOIN pais ON pais.id = persona.id_pais\n"+
                "WHERE persona.cedula LIKE '%"+cedula+"%'";
            }
            
            modelo_tabla = new DefaultTableModel(null, titulos);
            sentenciasql = coneccionsql.createStatement();
            ResultSet rs = sentenciasql.executeQuery(stsql);

            //arreglo fila, para almacenar registros
            String[] fila = new String[5];
            //while para insertar registros en la tabla
            while (rs.next()) {
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("cedula");
                fila[2] = rs.getString("nombre");
                fila[3] = rs.getString("fecha_nacimiento");
                fila[4] = rs.getString("pais");

                modelo_tabla.addRow(fila);
            }

            //agrego el default model
            TablaPersonas.setModel(modelo_tabla);

            //definir el ancho de las columnas
            int[] anchos = {10, 30, 100, 30, 30};
            for (int i = 0; i < TablaPersonas.getColumnCount(); i++) {
                TablaPersonas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    Integer buscarPais(String nombre_pais) {
        try {
            String stsql = "SELECT id FROM pais WHERE nombre = '"+nombre_pais+"'";
            sentenciasql = coneccionsql.createStatement();
            ResultSet rs = sentenciasql.executeQuery(stsql);
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el id del pais");
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        comboPaises = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        campoCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPersonas = new javax.swing.JTable();
        botonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonBorrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox<>();
        campoFiltro = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);

        jLabel5.setText("Paises:");

        comboPaises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboPaisesMouseClicked(evt);
            }
        });

        jLabel3.setText("Cedula:");

        jButton1.setText("+");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel4.setText("Nombre:");

        botonGuardar.setText("GUARDAR");
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });

        TablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPersonas);

        botonEditar.setText("EDITAR");
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PERSONA");

        botonBorrar.setText("BORRAR");
        botonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBorrarMouseClicked(evt);
            }
        });

        jLabel6.setText("Fecha Nac:");

        campoFecha.setDateFormatString("dd/MM/yyyy");

        jLabel2.setText("Filtro:");

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "Nombre" }));
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });

        campoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoFiltroKeyReleased(evt);
            }
        });

        jButton2.setText("PDF");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboPaises, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(botonGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBorrar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)
                                .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboPaises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonGuardar)
                            .addComponent(botonEditar)
                            .addComponent(botonBorrar))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Paises paises = new Paises();
        Principal.Escritorio.add(paises);
        Principal.centrarFormulario(paises);
        paises.show();                   
    }//GEN-LAST:event_jButton1MouseClicked

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
        try {
            String cedula = campoCedula.getText();
            String nombre = campoNombre.getText();
            String nombre_pais = comboPaises.getSelectedItem().toString();
            java.util.Date fecha_nacimiento = campoFecha.getDate();
            
            String sqlguardar = "INSERT INTO persona (cedula, nombre, fecha_nacimiento, id_pais) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = coneccionsql.prepareStatement(sqlguardar);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setDate(3, convertUtilToSql(fecha_nacimiento));
            ps.setInt(4, buscarPais(nombre_pais));
            int n = ps.executeUpdate();
            if (n > 0) {
                campoCedula.setText("");
                campoNombre.setText("");
                campoCedula.requestFocus();
                llenarTablar("");
                JOptionPane.showMessageDialog(this, "Se guardó correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar");
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(rootPane, "Error: No se podo registrar a la persona!");
        }
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void TablaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPersonasMouseClicked
        if (evt.getButton() == 1) {
            int fila = TablaPersonas.getSelectedRow();
            try {
                String stsql = "SELECT persona.id, persona.cedula, persona.nombre, persona.fecha_nacimiento, pais.nombre AS pais \n" +
                                "FROM persona\n" +
                                "JOIN pais ON pais.id = persona.id_pais WHERE persona.id = " + TablaPersonas.getValueAt(fila, 0);
                sentenciasql = coneccionsql.createStatement();
                ResultSet rs = sentenciasql.executeQuery(stsql);
                rs.next();

                id_persona = rs.getInt("id");
                campoCedula.setText(rs.getString("cedula"));
                campoNombre.setText(rs.getString("nombre"));
                comboPaises.setSelectedItem(rs.getString("pais"));
                campoFecha.setDate(rs.getDate("fecha_nacimiento"));

                botonEditar.setVisible(true);
                botonGuardar.setVisible(false);
                botonBorrar.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_TablaPersonasMouseClicked

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        try {
            String cedula = campoCedula.getText();
            String nombre = campoNombre.getText();
            String nombre_pais = comboPaises.getSelectedItem().toString();
            java.util.Date fecha_nacimiento = campoFecha.getDate();
                
            //Guardar en la base de datos
            String stactualizar = "UPDATE persona SET cedula=?, nombre=? , fecha_nacimiento=?, id_pais=? WHERE id=?";
            PreparedStatement ps = coneccionsql.prepareStatement(stactualizar);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setDate(3, convertUtilToSql(fecha_nacimiento));
            ps.setInt(4, buscarPais(nombre_pais));
            ps.setInt(5, id_persona);
            int n = ps.executeUpdate();
            if (n > 0) {
                //limpiar formulario
                campoCedula.setText("");
                campoNombre.setText("");

                //reiniciar el estado de los botones
                botonGuardar.setVisible(true);
                botonEditar.setVisible(false);

                llenarTablar("");
                JOptionPane.showMessageDialog(this, "Se actualizo correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar");
            }
            ps.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        try {

            //Borrar registro en la base de datos
            String stborrar = "DELETE FROM persona WHERE id =" + id_persona;
            PreparedStatement ps = coneccionsql.prepareStatement(stborrar);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(this, "Se borro correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al borrar");
            }
            ps.close();

            llenarTablar("");
            //limpiar formulario
            campoCedula.setText("");
            campoNombre.setText("");

            //Reiniciar el estado de los botones
            botonGuardar.setVisible(true);
            botonEditar.setVisible(false);
            botonBorrar.setVisible(false);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_botonBorrarMouseClicked

    private void comboPaisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboPaisesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPaisesMouseClicked

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFiltroActionPerformed

    private void campoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFiltroKeyReleased
        String filtro = comboFiltro.getSelectedItem().toString();
        llenarTablar(filtro);
    }//GEN-LAST:event_campoFiltroKeyReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            //Buscar la carpeta temporal del sistema operativo
            String carpetaTemporal = "C:\\reportes/";

            //Generar un nombre aleatorio para el PDF
            UUID uuid = UUID.randomUUID();
            String fecha = new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date());
            String nombreAleatorio = uuid.toString() + "-" + fecha + ".pdf";

            //Generar el PDF el disco usando los datos de la tabla
            Document doc = new Document(PageSize.LEGAL);
            doc.setPageSize(PageSize.LEGAL.rotate());
            PdfWriter.getInstance(doc, new FileOutputStream(carpetaTemporal + nombreAleatorio));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(TablaPersonas.getColumnCount());
            pdfTable.setTotalWidth(920);
            pdfTable.setHorizontalAlignment(0);
            pdfTable.setLockedWidth(true);

            //Agregamos el titulo
            Paragraph titulo = new Paragraph("Listado de Personas",
                    FontFactory.getFont("arial", // fuente
                            20, // tamaño
                            Font.BOLD, // estilo
                            BaseColor.BLUE));               // color
            titulo.setLeading(1, 1);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            doc.add(new Paragraph(" "));
            
            pdfTable.setWidths(new int[]{20,20,100,50,50});
            
            //Cabeceras de la tabla
            for (int i = 0; i < TablaPersonas.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(TablaPersonas.getColumnName(i),
                FontFactory.getFont(FontFactory.HELVETICA, 8, BaseColor.BLACK)));
                cell.setPadding(0);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                pdfTable.addCell(cell);
            }
            
            //Extraer los datos de cada fila del Jtable e insertar en el PDF
            for (int rows = 0; rows < TablaPersonas.getRowCount(); rows++) {
                for (int cols = 0; cols < TablaPersonas.getColumnCount(); cols++) {
                    PdfPCell cell = new PdfPCell(new Phrase(TablaPersonas.getModel().getValueAt(rows, cols).toString(),
                    FontFactory.getFont(FontFactory.HELVETICA, 8, BaseColor.BLACK)));
                    pdfTable.addCell(cell);
                    //pdfTable.addCell(tablaReportes.getModel().getValueAt(rows, cols).toString());
                }
            }
            doc.add(pdfTable);
            doc.close();

            //Abrimos el archivo generado en el disco con el programa predeterminado
            // del sistema operativo, es quivalente a darle doble click
            File myFile = new File(carpetaTemporal + nombreAleatorio);
            Desktop.getDesktop().open(myFile);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPersonas;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField campoCedula;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField campoFiltro;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> comboFiltro;
    public static javax.swing.JComboBox<String> comboPaises;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
