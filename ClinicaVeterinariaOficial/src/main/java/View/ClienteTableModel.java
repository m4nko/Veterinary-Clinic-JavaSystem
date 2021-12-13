package View;

import Model.Cliente;

import java.util.List;

public class ClienteTableModel extends GenericTableModel{

    public ClienteTableModel(List vDados) {
        super(vDados, new String[]{"Nome", "Endereço", "CEP", "Email", "Telefone"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("ColumnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) vDados.get(rowIndex);

        switch (columnIndex){
            case 0:
                return cliente.getNome();
            case 1:
                return cliente.getEndereco();
            case 2:
                return cliente.getCep();
            case 3:
                return cliente.getEmail();
            case 4:
                return cliente.getTelefone();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Cliente cliente = (Cliente) vDados.get(rowIndex);

        switch (columnIndex){
            case 0:
                cliente.setNome((String)aValue);
                break;
            case 1:
                cliente.setEndereco((String)aValue);
                break;
            case 2:
                cliente.setCep((String) aValue);
                break;
            case 3:
                cliente.setEmail((String) aValue);
                break;
            case 4:
                cliente.setTelefone((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        // Tudo do cliente pode ser editado
        return true;
    }

}