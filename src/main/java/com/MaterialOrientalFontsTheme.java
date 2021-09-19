package com;

import mdlaf.themes.JMarsDarkTheme;
import mdlaf.utils.MaterialColors;
import mdlaf.utils.MaterialImageFactory;
import mdlaf.utils.icons.MaterialIconFont;

import java.awt.*;

/**
 * @author WangYuyang
 * @version 1.0
 * @date 2021/4/15 17:55
 */

public class MaterialOrientalFontsTheme extends JMarsDarkTheme {
    @Override
    protected void installIcons() {
        super.installIcons();
        this.selectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(MaterialIconFont.CHECK_BOX, MaterialColors.WHITE);
        this.unselectedCheckBoxIconSelectionRowTable = MaterialImageFactory.getInstance().getImage(MaterialIconFont.CHECK_BOX_OUTLINE_BLANK, MaterialColors.WHITE);
        this.selectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(MaterialIconFont.CHECK_BOX, this.highlightBackgroundPrimary);
        this.unselectedCheckBoxIconTable = MaterialImageFactory.getInstance().getImage(MaterialIconFont.CHECK_BOX_OUTLINE_BLANK, this.highlightBackgroundPrimary);
    }

    @Override
    protected void installFonts() {
        this.fontBold = new javax.swing.plaf.FontUIResource(Font.SANS_SERIF, Font.BOLD, 14);
        this.fontItalic = new javax.swing.plaf.FontUIResource(Font.SANS_SERIF, Font.ITALIC, 14);
        this.fontMedium = new javax.swing.plaf.FontUIResource(Font.SANS_SERIF, Font.PLAIN, 14);
        this.fontRegular = new javax.swing.plaf.FontUIResource(Font.SANS_SERIF, Font.PLAIN, 14);
    }
}