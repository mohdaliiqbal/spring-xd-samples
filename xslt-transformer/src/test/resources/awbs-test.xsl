<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" omit-xml-declaration="yes" indent="no" media-type="text/plain"/>
<xsl:strip-space elements="*"/>
<xsl:template match="/">
      <xsl:for-each select="catalog/cd">
        <xsl:value-of select="awbsid"/>
        <xsl:text>,</xsl:text>
        <xsl:value-of select="awbsdescription"/>
      </xsl:for-each>
</xsl:template>

  <xsl:strip-space elements="*"/>
</xsl:stylesheet>