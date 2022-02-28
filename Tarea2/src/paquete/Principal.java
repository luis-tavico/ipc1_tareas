package paquete;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        int opcion = 0;
        int posicion_cliente = 0;
        int posicion_cuenta = 0;
        int posicion_transferencia = 0;
        Cliente[] cliente = new Cliente[20];
        Cuenta[] cuenta = new Cuenta[20];
        Transferencia[] transferencia = new Transferencia[30];
        boolean existe_cliente = false;
        boolean existe_cuenta = false;
        boolean existe_cuentaOrigen = false;
        boolean existe_cuentaDestino = false;
        int numero_cuenta = 1;
        long cui;
        String nombre;
        String apellido;
        String tipo;
        float fondo;
        int cuentaOrigen;
        int cuentaDestino;
        float monto;
        int numeroCuenta;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Nuevo cliente\n2. Nueva cuenta\n3. Nueva transferencia"
                        + "\n4. Mostrar datos personales y cuentas\n5. Historial de transferencias\n6. Salir\nIngrese una opcion:", "Menu Principal", -1));
                switch (opcion) {
                    case 1:
                        cui = Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese el CUI:", "Nuevo Cliente", -1));
                        nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre:", "Nuevo Cliente", -1);
                        apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido:", "Nuevo Cliente", -1);
                        for (int i = 0; i < cliente.length; i++) {
                            if (cliente[i] != null) {
                                if (cliente[i].getCui() == cui) {
                                    existe_cliente = true;
                                }
                            }
                        }
                        if (existe_cliente) {
                            JOptionPane.showMessageDialog(null, "¡Error, el CUI ingresado ya existe!");
                        } else {
                            cliente[posicion_cliente] = new Cliente(cui, nombre, apellido);
                            posicion_cliente++;
                            JOptionPane.showMessageDialog(null, "¡Cliente creado exitosamente!");
                        }
                        existe_cliente = false;
                        break;
                    case 2:
                        cui = Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese el CUI:", "Nuevo Cuenta", -1));
                        tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo de cuenta \n(monetaria/ahorro):", "Nuevo Cuenta", -1);
                        fondo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el valor de apertura:", "Nuevo Cuenta", -1));
                        for (int i = 0; i < cliente.length; i++) {
                            if (cliente[i] != null) {
                                if (cliente[i].getCui() == cui) {
                                    existe_cliente = true;
                                }
                            }
                        }
                        for (int i = 0; i < cuenta.length; i++) {
                            if (cuenta[i] != null) {
                                if (cuenta[i].getCui() == cui) {
                                    existe_cuenta = true;
                                }
                            }
                        }
                        if (existe_cliente == true && existe_cuenta == false) {
                            cuenta[posicion_cuenta] = new Cuenta(cui, numero_cuenta, tipo, fondo);
                            JOptionPane.showMessageDialog(null, "¡Cuenta creada exitosamente!\nSu numero de cuenta es: " + numero_cuenta);
                            numero_cuenta++;
                            posicion_cuenta++;
                        } else if (existe_cliente == true && existe_cuenta == true) {
                            JOptionPane.showMessageDialog(null, "¡El cliente ya posee una cuenta!");
                        } else if (existe_cliente == false && existe_cuenta == false) {
                            JOptionPane.showMessageDialog(null, "¡Error, el CUI ingresado no existe!");
                        }
                        existe_cliente = false;
                        existe_cuenta = false;
                        break;
                    case 3:
                        int posicionO = 0;
                        int posicionD = 0;
                        cuentaOrigen = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cuenta origen:", "Nuevo Transferencia", -1));
                        cuentaDestino = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cuenta destino:", "Nuevo Transferencia", -1));
                        monto = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el valor del deposito:", "Nuevo Transferencia", -1));
                        for (int i = 0; i < cuenta.length; i++) {
                            if (cuenta[i] != null) {
                                if (cuenta[i].getNumero_cuenta() == cuentaOrigen) {
                                    existe_cuentaOrigen = true;
                                    posicionO = i;
                                }
                            }
                        }
                        for (int i = 0; i < cuenta.length; i++) {
                            if (cuenta[i] != null) {
                                if (cuenta[i].getNumero_cuenta() == cuentaDestino) {
                                    existe_cuentaDestino = true;
                                    posicionD = i;
                                }
                            }
                        }
                        if (existe_cuentaOrigen == true && existe_cuentaDestino == true) {
                            float totalO = cuenta[posicionO].getFondo();
                            float totalD = cuenta[posicionD].getFondo();
                            if (monto <= totalO) {
                                cuenta[posicionO].setFondo(totalO - monto);
                                cuenta[posicionD].setFondo(totalD + monto);
                                String fecha_hora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
                                transferencia[posicion_transferencia] = new Transferencia(cuentaOrigen, cuentaDestino, monto, fecha_hora);
                                posicion_transferencia++;
                                JOptionPane.showMessageDialog(null, "¡Transferencia realizada exitosamente!");
                            } else {
                                JOptionPane.showMessageDialog(null, "¡Fondos insuficientes!");
                            }
                        } else if (existe_cuentaOrigen == true && existe_cuentaDestino == false) {
                            JOptionPane.showMessageDialog(null, "¡Error, la cuenta destino no existe!");
                        } else if (existe_cuentaOrigen == false && existe_cuentaDestino == true) {
                            JOptionPane.showMessageDialog(null, "¡Error, la cuenta origen no existe!");
                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error, asegurese de ingresar los numeros\nde cuenta correctos!");
                        }
                        existe_cuentaOrigen = false;
                        existe_cuentaDestino = false;
                        break;
                    case 4:
                        int posicionCliente = 0;
                        int posicionCuenta = 0;
                        String info = "";
                        cui = Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese el CUI:", "Informacion", -1));
                        for (int i = 0; i < cliente.length; i++) {
                            if (cliente[i] != null) {
                                if (cliente[i].getCui() == cui) {
                                    existe_cliente = true;
                                    posicionCliente = i;
                                }
                            }
                        }
                        for (int i = 0; i < cuenta.length; i++) {
                            if (cuenta[i] != null) {
                                if (cuenta[i].getCui() == cui) {
                                    existe_cuenta = true;
                                    posicionCuenta = i;
                                }
                            }
                        }
                        if (existe_cliente == true && existe_cuenta == true) {
                            info += cliente[posicionCliente].toString();
                            info += cuenta[posicionCuenta].toString();
                            JOptionPane.showMessageDialog(null, info);
                        } else if (existe_cliente == true && existe_cuenta == false) {
                            info += cliente[posicionCliente].toString();
                            JOptionPane.showMessageDialog(null, info);
                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error, el cliente no existe!");
                        }
                        existe_cliente = false;
                        existe_cuenta = false;
                        break;
                    case 5:
                        String historial = "";
                        numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cuenta:", "Historial", -1));
                        for (int i = 0; i < cuenta.length; i++) {
                            if (cuenta[i] != null) {
                                if (cuenta[i].getNumero_cuenta() == numeroCuenta) {
                                    existe_cuenta = true;
                                }
                            }
                        }
                        for (int i = 0; i < transferencia.length; i++) {
                            if (transferencia[i] != null) {
                                if (transferencia[i].getCuentaOrigen() == numeroCuenta) {
                                    historial += transferencia[i].toString();
                                }
                            }
                        }

                        if (!historial.equals("") && existe_cuenta == true) {
                            JOptionPane.showMessageDialog(null, historial);
                        } else if (historial.equals("") && existe_cuenta == true) {
                            JOptionPane.showMessageDialog(null, "¡Sin transferencias!");
                        } else if (historial.equals("") && existe_cuenta == false) {
                            JOptionPane.showMessageDialog(null, "¡La cuenta no existe!");
                        }
                        existe_cuenta = false;
                        break;
                    case 6:
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "¡Error, debio ingresar un numero!");
            }
        } while (opcion != 6);

    }
}
