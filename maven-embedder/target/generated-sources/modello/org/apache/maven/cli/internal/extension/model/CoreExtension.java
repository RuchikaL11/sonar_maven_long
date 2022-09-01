// =================== DO NOT EDIT THIS FILE ====================
// Generated by Modello 1.11,
// any modifications will be overwritten.
// ==============================================================

package org.apache.maven.cli.internal.extension.model;

/**
 * Describes a build extension to utilise.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class CoreExtension
    implements java.io.Serializable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The group ID of the extension's artifact.
     */
    private String groupId;

    /**
     * The artifact ID of the extension.
     */
    private String artifactId;

    /**
     * The version of the extension.
     */
    private String version;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Get the artifact ID of the extension.
     * 
     * @return String
     */
    public String getArtifactId()
    {
        return this.artifactId;
    } //-- String getArtifactId()

    /**
     * Get the group ID of the extension's artifact.
     * 
     * @return String
     */
    public String getGroupId()
    {
        return this.groupId;
    } //-- String getGroupId()

    /**
     * Get the version of the extension.
     * 
     * @return String
     */
    public String getVersion()
    {
        return this.version;
    } //-- String getVersion()

    /**
     * Set the artifact ID of the extension.
     * 
     * @param artifactId
     */
    public void setArtifactId( String artifactId )
    {
        this.artifactId = artifactId;
    } //-- void setArtifactId( String )

    /**
     * Set the group ID of the extension's artifact.
     * 
     * @param groupId
     */
    public void setGroupId( String groupId )
    {
        this.groupId = groupId;
    } //-- void setGroupId( String )

    /**
     * Set the version of the extension.
     * 
     * @param version
     */
    public void setVersion( String version )
    {
        this.version = version;
    } //-- void setVersion( String )

}