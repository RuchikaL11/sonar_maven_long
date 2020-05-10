// =================== DO NOT EDIT THIS FILE ====================
// Generated by Modello 1.11,
// any modifications will be overwritten.
// ==============================================================

package org.apache.maven.model;

/**
 * 
 *         
 *         The <code>&lt;plugin&gt;</code> element contains
 * informations required for a report plugin.
 *         
 *       
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class ReportPlugin
    extends ConfigurationContainer
    implements java.io.Serializable, java.lang.Cloneable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The group ID of the reporting plugin in the repository.
     */
    private String groupId = "org.apache.maven.plugins";

    /**
     * The artifact ID of the reporting plugin in the repository.
     */
    private String artifactId;

    /**
     * The version of the reporting plugin to be used.
     */
    private String version;

    /**
     * Field reportSets.
     */
    private java.util.List<ReportSet> reportSets;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addReportSet.
     * 
     * @param reportSet
     */
    public void addReportSet( ReportSet reportSet )
    {
        getReportSets().add( reportSet );
    } //-- void addReportSet( ReportSet )

    /**
     * Method clone.
     * 
     * @return ReportPlugin
     */
    public ReportPlugin clone()
    {
        try
        {
            ReportPlugin copy = (ReportPlugin) super.clone();

            if ( this.reportSets != null )
            {
                copy.reportSets = new java.util.ArrayList<ReportSet>();
                for ( ReportSet item : this.reportSets )
                {
                    copy.reportSets.add( ( (ReportSet) item).clone() );
                }
            }

            return copy;
        }
        catch ( java.lang.Exception ex )
        {
            throw (java.lang.RuntimeException) new java.lang.UnsupportedOperationException( getClass().getName()
                + " does not support clone()" ).initCause( ex );
        }
    } //-- ReportPlugin clone()

    /**
     * Get the artifact ID of the reporting plugin in the
     * repository.
     * 
     * @return String
     */
    public String getArtifactId()
    {
        return this.artifactId;
    } //-- String getArtifactId()

    /**
     * Get the group ID of the reporting plugin in the repository.
     * 
     * @return String
     */
    public String getGroupId()
    {
        return this.groupId;
    } //-- String getGroupId()

    /**
     * Method getReportSets.
     * 
     * @return List
     */
    public java.util.List<ReportSet> getReportSets()
    {
        if ( this.reportSets == null )
        {
            this.reportSets = new java.util.ArrayList<ReportSet>();
        }

        return this.reportSets;
    } //-- java.util.List<ReportSet> getReportSets()

    /**
     * Get the version of the reporting plugin to be used.
     * 
     * @return String
     */
    public String getVersion()
    {
        return this.version;
    } //-- String getVersion()

    /**
     * Method removeReportSet.
     * 
     * @param reportSet
     */
    public void removeReportSet( ReportSet reportSet )
    {
        getReportSets().remove( reportSet );
    } //-- void removeReportSet( ReportSet )

    /**
     * Set the artifact ID of the reporting plugin in the
     * repository.
     * 
     * @param artifactId
     */
    public void setArtifactId( String artifactId )
    {
        this.artifactId = artifactId;
    } //-- void setArtifactId( String )

    /**
     * Set the group ID of the reporting plugin in the repository.
     * 
     * @param groupId
     */
    public void setGroupId( String groupId )
    {
        this.groupId = groupId;
    } //-- void setGroupId( String )

    /**
     * Set multiple specifications of a set of reports, each having
     * (possibly) different
     *             configuration. This is the reporting parallel to
     * an <code>execution</code> in the build.
     * 
     * @param reportSets
     */
    public void setReportSets( java.util.List<ReportSet> reportSets )
    {
        this.reportSets = reportSets;
    } //-- void setReportSets( java.util.List )

    /**
     * Set the version of the reporting plugin to be used.
     * 
     * @param version
     */
    public void setVersion( String version )
    {
        this.version = version;
    } //-- void setVersion( String )

    
            
    private java.util.Map<String, ReportSet> reportSetMap = null;

    /**
     * Reset the <code>reportSetMap</code> field to <code>null</code>
     */
    public void flushReportSetMap()
    {
        this.reportSetMap = null;
    }

    /**
     * @return a Map of reportSets field with <code>ReportSet#getId()</code> as key
     * @see org.apache.maven.model.ReportSet#getId()
     */
    public java.util.Map<String, ReportSet> getReportSetsAsMap()
    {
        if ( reportSetMap == null )
        {
            reportSetMap = new java.util.LinkedHashMap<String, ReportSet>();
            if ( getReportSets() != null )
            {
                for ( java.util.Iterator<ReportSet> i = getReportSets().iterator(); i.hasNext(); )
                {
                    ReportSet reportSet = (ReportSet) i.next();
                    reportSetMap.put( reportSet.getId(), reportSet );
                }
            }
        }

        return reportSetMap;
    }

    /**
     * @return the key of the report plugin, ie <code>groupId:artifactId</code>
     */
    public String getKey()
    {
        return constructKey( groupId, artifactId );
    }

    /**
     * @param groupId The group ID of the plugin in the repository
     * @param artifactId The artifact ID of the reporting plugin in the repository
     * @return the key of the report plugin, ie <code>groupId:artifactId</code>
     */
    public static String constructKey( String groupId, String artifactId )
    {
        return groupId + ":" + artifactId;
    }
            
          
}
