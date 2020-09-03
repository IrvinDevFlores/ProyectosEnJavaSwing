import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.*; 

class ItemRenderer extends BasicComboBoxRenderer
    {
        public Component getListCellRendererComponent(
            JList list,Object value,int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
 
            if (value != null)
            {
                Proveedor item = (Proveedor)value;
                setText( item.GetItemName());
            }
 
            if (index == -1)
            {
                Proveedor item = (Proveedor) value;
                setText( item.GetItemName() );
            }
 
 
            return this;
        }
    }