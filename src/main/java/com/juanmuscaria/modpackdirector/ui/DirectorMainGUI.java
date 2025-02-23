package com.juanmuscaria.modpackdirector.ui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.juanmuscaria.modpackdirector.i18n.Messages;
import com.juanmuscaria.modpackdirector.logging.LoggerDelegate;
import com.juanmuscaria.modpackdirector.ui.page.ConsentPage;
import com.juanmuscaria.modpackdirector.ui.page.MessagePage;
import com.juanmuscaria.modpackdirector.ui.page.ModSelectionPage;
import com.juanmuscaria.modpackdirector.ui.page.ProgressPage;
import com.juanmuscaria.modpackdirector.ui.theme.UITheme;
import lombok.Getter;
import net.jan.moddirector.core.manage.install.InstallableMod;
import net.jan.moddirector.core.manage.select.InstallSelector;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Getter
public class DirectorMainGUI extends JFrame {
    private final Messages messages;
    private final LoggerDelegate logger;
    private JPanel content;
    private JLabel modpackName;
    private JLabel modpackIcon;
    private JPanel page;
    private JPanel root;
    private Component currentPage;

    public DirectorMainGUI(Messages messages, LoggerDelegate logger) {
        this.messages = messages;
        this.logger = logger;
        add(root);
        modpackName.setFont(new Font(modpackName.getFont().getName(), Font.BOLD, 20));
        pack();
        setMinimumSize(getPreferredSize());
    }

    public ProgressPage progressPage(String titleKey, Object... params) {
        return setCurrentPage(new ProgressPage(messages.get(titleKey, params)));
    }

    public ConsentPage consent(List<InstallableMod> mods) {
        return setCurrentPage(new ConsentPage(mods, messages));
    }

    public ModSelectionPage selectionPage(InstallSelector selector) {
        return setCurrentPage(new ModSelectionPage(selector, messages));
    }

    public MessagePage messagePage(String titleKey, String messageKey, String buttonKey) {
        return setCurrentPage(new MessagePage(messages, titleKey, messageKey, buttonKey));
    }

    private <T extends Component> T setCurrentPage(T newPage) {
        if (currentPage != null) {
            page.remove(currentPage);
        }
        this.currentPage = newPage;
        this.page.add(currentPage);
        this.page.revalidate();
        this.page.repaint();
        return newPage;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        root = new JPanel();
        root.setLayout(new GridLayoutManager(1, 1, new Insets(5, 10, 10, 10), -1, -1));
        content = new JPanel();
        content.setLayout(new BorderLayout(0, 0));
        root.add(content, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(650, 400), null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 5, 0), -1, -1));
        content.add(panel1, BorderLayout.NORTH);
        modpackName = new JLabel();
        modpackName.setEnabled(true);
        modpackName.setHorizontalAlignment(0);
        modpackName.setHorizontalTextPosition(0);
        modpackName.setOpaque(false);
        modpackName.setText("Modpack Director");
        panel1.add(modpackName, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        modpackIcon = new JLabel();
        modpackIcon.setText("");
        panel1.add(modpackIcon, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(64, 64), new Dimension(64, 64), new Dimension(64, 64), 0, false));
        page = new JPanel();
        page.setLayout(new BorderLayout(0, 0));
        content.add(page, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return root;
    }

    public void setModpackIcon(Image icon, Dimension dimension) {
        if (icon == null) {
            var img = UITheme.getDefaultIcon(logger);
            setIconImage(img);
            modpackIcon.setIcon(new ImageIcon(img.getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
        } else {
            modpackIcon.setMinimumSize(dimension);
            modpackIcon.setMaximumSize(dimension);
            modpackIcon.setPreferredSize(dimension);
            setIconImage(icon);
            modpackIcon.setIcon(new ImageIcon(icon.getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH)));
        }
    }
}
