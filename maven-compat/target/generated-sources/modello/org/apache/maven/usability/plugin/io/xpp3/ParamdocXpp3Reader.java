// =================== DO NOT EDIT THIS FILE ====================
// Generated by Modello 1.11,
// any modifications will be overwritten.
// ==============================================================

package org.apache.maven.usability.plugin.io.xpp3;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.text.DateFormat;
import org.apache.maven.usability.plugin.Expression;
import org.apache.maven.usability.plugin.ExpressionDocumentation;
import org.codehaus.plexus.util.ReaderFactory;
import org.codehaus.plexus.util.xml.pull.EntityReplacementMap;
import org.codehaus.plexus.util.xml.pull.MXParser;
import org.codehaus.plexus.util.xml.pull.XmlPullParser;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * Class ParamdocXpp3Reader.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class ParamdocXpp3Reader
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * If set the parser will be loaded with all single characters
     * from the XHTML specification.
     * The entities used:
     * <ul>
     * <li>http://www.w3.org/TR/xhtml1/DTD/xhtml-lat1.ent</li>
     * <li>http://www.w3.org/TR/xhtml1/DTD/xhtml-special.ent</li>
     * <li>http://www.w3.org/TR/xhtml1/DTD/xhtml-symbol.ent</li>
     * </ul>
     */
    private boolean addDefaultEntities = true;

    /**
     * Field contentTransformer.
     */
    public final ContentTransformer contentTransformer;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParamdocXpp3Reader()
    {
        this( new ContentTransformer()
        {
            public String transform( String source, String fieldName )
            {
                return source;
            }
        } );
    } //-- org.apache.maven.usability.plugin.io.xpp3.ParamdocXpp3Reader()

    public ParamdocXpp3Reader(ContentTransformer contentTransformer)
    {
        this.contentTransformer = contentTransformer;
    } //-- org.apache.maven.usability.plugin.io.xpp3.ParamdocXpp3Reader(ContentTransformer)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method checkFieldWithDuplicate.
     * 
     * @param parser
     * @param parsed
     * @param alias
     * @param tagName
     * @throws XmlPullParserException
     * @return boolean
     */
    private boolean checkFieldWithDuplicate( XmlPullParser parser, String tagName, String alias, java.util.Set parsed )
        throws XmlPullParserException
    {
        if ( !( parser.getName().equals( tagName ) || parser.getName().equals( alias ) ) )
        {
            return false;
        }
        if ( !parsed.add( tagName ) )
        {
            throw new XmlPullParserException( "Duplicated tag: '" + tagName + "'", parser, null );
        }
        return true;
    } //-- boolean checkFieldWithDuplicate( XmlPullParser, String, String, java.util.Set )

    /**
     * Method checkUnknownAttribute.
     * 
     * @param parser
     * @param strict
     * @param tagName
     * @param attribute
     * @throws XmlPullParserException
     * @throws IOException
     */
    private void checkUnknownAttribute( XmlPullParser parser, String attribute, String tagName, boolean strict )
        throws XmlPullParserException, IOException
    {
        // strictXmlAttributes = true for model: if strict == true, not only elements are checked but attributes too
        if ( strict )
        {
            throw new XmlPullParserException( "Unknown attribute '" + attribute + "' for tag '" + tagName + "'", parser, null );
        }
    } //-- void checkUnknownAttribute( XmlPullParser, String, String, boolean )

    /**
     * Method checkUnknownElement.
     * 
     * @param parser
     * @param strict
     * @throws XmlPullParserException
     * @throws IOException
     */
    private void checkUnknownElement( XmlPullParser parser, boolean strict )
        throws XmlPullParserException, IOException
    {
        if ( strict )
        {
            throw new XmlPullParserException( "Unrecognised tag: '" + parser.getName() + "'", parser, null );
        }

        for ( int unrecognizedTagCount = 1; unrecognizedTagCount > 0; )
        {
            int eventType = parser.next();
            if ( eventType == XmlPullParser.START_TAG )
            {
                unrecognizedTagCount++;
            }
            else if ( eventType == XmlPullParser.END_TAG )
            {
                unrecognizedTagCount--;
            }
        }
    } //-- void checkUnknownElement( XmlPullParser, boolean )

    /**
     * Returns the state of the "add default entities" flag.
     * 
     * @return boolean
     */
    public boolean getAddDefaultEntities()
    {
        return addDefaultEntities;
    } //-- boolean getAddDefaultEntities()

    /**
     * Method getBooleanValue.
     * 
     * @param s
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return boolean
     */
    private boolean getBooleanValue( String s, String attribute, XmlPullParser parser )
        throws XmlPullParserException
    {
        return getBooleanValue( s, attribute, parser, null );
    } //-- boolean getBooleanValue( String, String, XmlPullParser )

    /**
     * Method getBooleanValue.
     * 
     * @param s
     * @param defaultValue
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return boolean
     */
    private boolean getBooleanValue( String s, String attribute, XmlPullParser parser, String defaultValue )
        throws XmlPullParserException
    {
        if ( s != null && s.length() != 0 )
        {
            return Boolean.valueOf( s ).booleanValue();
        }
        if ( defaultValue != null )
        {
            return Boolean.valueOf( defaultValue ).booleanValue();
        }
        return false;
    } //-- boolean getBooleanValue( String, String, XmlPullParser, String )

    /**
     * Method getByteValue.
     * 
     * @param s
     * @param strict
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return byte
     */
    private byte getByteValue( String s, String attribute, XmlPullParser parser, boolean strict )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            try
            {
                return Byte.valueOf( s ).byteValue();
            }
            catch ( NumberFormatException nfe )
            {
                if ( strict )
                {
                    throw new XmlPullParserException( "Unable to parse element '" + attribute + "', must be a byte", parser, nfe );
                }
            }
        }
        return 0;
    } //-- byte getByteValue( String, String, XmlPullParser, boolean )

    /**
     * Method getCharacterValue.
     * 
     * @param s
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return char
     */
    private char getCharacterValue( String s, String attribute, XmlPullParser parser )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            return s.charAt( 0 );
        }
        return 0;
    } //-- char getCharacterValue( String, String, XmlPullParser )

    /**
     * Method getDateValue.
     * 
     * @param s
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return Date
     */
    private java.util.Date getDateValue( String s, String attribute, XmlPullParser parser )
        throws XmlPullParserException
    {
        return getDateValue( s, attribute, null, parser );
    } //-- java.util.Date getDateValue( String, String, XmlPullParser )

    /**
     * Method getDateValue.
     * 
     * @param s
     * @param parser
     * @param dateFormat
     * @param attribute
     * @throws XmlPullParserException
     * @return Date
     */
    private java.util.Date getDateValue( String s, String attribute, String dateFormat, XmlPullParser parser )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            String effectiveDateFormat = dateFormat;
            if ( dateFormat == null )
            {
                effectiveDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS";
            }
            if ( "long".equals( effectiveDateFormat ) )
            {
                try
                {
                    return new java.util.Date( Long.parseLong( s ) );
                }
                catch ( NumberFormatException e )
                {
                    throw new XmlPullParserException( e.getMessage(), parser, e );
                }
            }
            else
            {
                try
                {
                    DateFormat dateParser = new java.text.SimpleDateFormat( effectiveDateFormat, java.util.Locale.US );
                    return dateParser.parse( s );
                }
                catch ( java.text.ParseException e )
                {
                    throw new XmlPullParserException( e.getMessage(), parser, e );
                }
            }
        }
        return null;
    } //-- java.util.Date getDateValue( String, String, String, XmlPullParser )

    /**
     * Method getDoubleValue.
     * 
     * @param s
     * @param strict
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return double
     */
    private double getDoubleValue( String s, String attribute, XmlPullParser parser, boolean strict )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            try
            {
                return Double.valueOf( s ).doubleValue();
            }
            catch ( NumberFormatException nfe )
            {
                if ( strict )
                {
                    throw new XmlPullParserException( "Unable to parse element '" + attribute + "', must be a floating point number", parser, nfe );
                }
            }
        }
        return 0;
    } //-- double getDoubleValue( String, String, XmlPullParser, boolean )

    /**
     * Method getFloatValue.
     * 
     * @param s
     * @param strict
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return float
     */
    private float getFloatValue( String s, String attribute, XmlPullParser parser, boolean strict )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            try
            {
                return Float.valueOf( s ).floatValue();
            }
            catch ( NumberFormatException nfe )
            {
                if ( strict )
                {
                    throw new XmlPullParserException( "Unable to parse element '" + attribute + "', must be a floating point number", parser, nfe );
                }
            }
        }
        return 0;
    } //-- float getFloatValue( String, String, XmlPullParser, boolean )

    /**
     * Method getIntegerValue.
     * 
     * @param s
     * @param strict
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return int
     */
    private int getIntegerValue( String s, String attribute, XmlPullParser parser, boolean strict )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            try
            {
                return Integer.valueOf( s ).intValue();
            }
            catch ( NumberFormatException nfe )
            {
                if ( strict )
                {
                    throw new XmlPullParserException( "Unable to parse element '" + attribute + "', must be an integer", parser, nfe );
                }
            }
        }
        return 0;
    } //-- int getIntegerValue( String, String, XmlPullParser, boolean )

    /**
     * Method getLongValue.
     * 
     * @param s
     * @param strict
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return long
     */
    private long getLongValue( String s, String attribute, XmlPullParser parser, boolean strict )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            try
            {
                return Long.valueOf( s ).longValue();
            }
            catch ( NumberFormatException nfe )
            {
                if ( strict )
                {
                    throw new XmlPullParserException( "Unable to parse element '" + attribute + "', must be a long integer", parser, nfe );
                }
            }
        }
        return 0;
    } //-- long getLongValue( String, String, XmlPullParser, boolean )

    /**
     * Method getRequiredAttributeValue.
     * 
     * @param s
     * @param strict
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return String
     */
    private String getRequiredAttributeValue( String s, String attribute, XmlPullParser parser, boolean strict )
        throws XmlPullParserException
    {
        if ( s == null )
        {
            if ( strict )
            {
                throw new XmlPullParserException( "Missing required value for attribute '" + attribute + "'", parser, null );
            }
        }
        return s;
    } //-- String getRequiredAttributeValue( String, String, XmlPullParser, boolean )

    /**
     * Method getShortValue.
     * 
     * @param s
     * @param strict
     * @param parser
     * @param attribute
     * @throws XmlPullParserException
     * @return short
     */
    private short getShortValue( String s, String attribute, XmlPullParser parser, boolean strict )
        throws XmlPullParserException
    {
        if ( s != null )
        {
            try
            {
                return Short.valueOf( s ).shortValue();
            }
            catch ( NumberFormatException nfe )
            {
                if ( strict )
                {
                    throw new XmlPullParserException( "Unable to parse element '" + attribute + "', must be a short integer", parser, nfe );
                }
            }
        }
        return 0;
    } //-- short getShortValue( String, String, XmlPullParser, boolean )

    /**
     * Method getTrimmedValue.
     * 
     * @param s
     * @return String
     */
    private String getTrimmedValue( String s )
    {
        if ( s != null )
        {
            s = s.trim();
        }
        return s;
    } //-- String getTrimmedValue( String )

    /**
     * Method interpolatedTrimmed.
     * 
     * @param value
     * @param context
     * @return String
     */
    private String interpolatedTrimmed( String value, String context )
    {
        return getTrimmedValue( contentTransformer.transform( value, context ) );
    } //-- String interpolatedTrimmed( String, String )

    /**
     * Method nextTag.
     * 
     * @param parser
     * @throws IOException
     * @throws XmlPullParserException
     * @return int
     */
    private int nextTag( XmlPullParser parser )
        throws IOException, XmlPullParserException
    {
        int eventType = parser.next();
        if ( eventType == XmlPullParser.TEXT )
        {
            eventType = parser.next();
        }
        if ( eventType != XmlPullParser.START_TAG && eventType != XmlPullParser.END_TAG )
        {
            throw new XmlPullParserException( "expected START_TAG or END_TAG not " + XmlPullParser.TYPES[eventType], parser, null );
        }
        return eventType;
    } //-- int nextTag( XmlPullParser )

    /**
     * @see ReaderFactory#newXmlReader
     * 
     * @param reader
     * @param strict
     * @throws IOException
     * @throws XmlPullParserException
     * @return ExpressionDocumentation
     */
    public ExpressionDocumentation read( Reader reader, boolean strict )
        throws IOException, XmlPullParserException
    {
        XmlPullParser parser = addDefaultEntities ? new MXParser(EntityReplacementMap.defaultEntityReplacementMap) : new MXParser( );

        parser.setInput( reader );


        return read( parser, strict );
    } //-- ExpressionDocumentation read( Reader, boolean )

    /**
     * @see ReaderFactory#newXmlReader
     * 
     * @param reader
     * @throws IOException
     * @throws XmlPullParserException
     * @return ExpressionDocumentation
     */
    public ExpressionDocumentation read( Reader reader )
        throws IOException, XmlPullParserException
    {
        return read( reader, true );
    } //-- ExpressionDocumentation read( Reader )

    /**
     * Method read.
     * 
     * @param in
     * @param strict
     * @throws IOException
     * @throws XmlPullParserException
     * @return ExpressionDocumentation
     */
    public ExpressionDocumentation read( InputStream in, boolean strict )
        throws IOException, XmlPullParserException
    {
        return read( ReaderFactory.newXmlReader( in ), strict );
    } //-- ExpressionDocumentation read( InputStream, boolean )

    /**
     * Method read.
     * 
     * @param in
     * @throws IOException
     * @throws XmlPullParserException
     * @return ExpressionDocumentation
     */
    public ExpressionDocumentation read( InputStream in )
        throws IOException, XmlPullParserException
    {
        return read( ReaderFactory.newXmlReader( in ) );
    } //-- ExpressionDocumentation read( InputStream )

    /**
     * Method parseExpression.
     * 
     * @param parser
     * @param strict
     * @throws IOException
     * @throws XmlPullParserException
     * @return Expression
     */
    private Expression parseExpression( XmlPullParser parser, boolean strict )
        throws IOException, XmlPullParserException
    {
        String tagName = parser.getName();
        Expression expression = new Expression();
        for ( int i = parser.getAttributeCount() - 1; i >= 0; i-- )
        {
            String name = parser.getAttributeName( i );
            String value = parser.getAttributeValue( i );

            if ( name.indexOf( ':' ) >= 0 )
            {
                // just ignore attributes with non-default namespace (for example: xmlns:xsi)
            }
            else
            {
                checkUnknownAttribute( parser, name, tagName, strict );
            }
        }
        java.util.Set parsed = new java.util.HashSet();
        while ( ( strict ? parser.nextTag() : nextTag( parser ) ) == XmlPullParser.START_TAG )
        {
            if ( checkFieldWithDuplicate( parser, "syntax", null, parsed ) )
            {
                expression.setSyntax( interpolatedTrimmed( parser.nextText(), "syntax" ) );
            }
            else if ( checkFieldWithDuplicate( parser, "description", null, parsed ) )
            {
                expression.setDescription( interpolatedTrimmed( parser.nextText(), "description" ) );
            }
            else if ( checkFieldWithDuplicate( parser, "configuration", null, parsed ) )
            {
                expression.setConfiguration( interpolatedTrimmed( parser.nextText(), "configuration" ) );
            }
            else if ( checkFieldWithDuplicate( parser, "cliOptions", null, parsed ) )
            {
                while ( parser.nextTag() == XmlPullParser.START_TAG )
                {
                    if ( "cliOption".equals( parser.getName() ) )
                    {
                        String key = null;
                        String value = null;
                        // explode mode.
                        while ( parser.nextTag() == XmlPullParser.START_TAG )
                        {
                            if ( "key".equals( parser.getName() ) )
                            {
                                key = parser.nextText();
                            }
                            else if ( "value".equals( parser.getName() ) )
                            {
                                value = parser.nextText().trim();
                            }
                            else
                            {
                                parser.nextText();
                            }
                        }
                        expression.addCliOption( key, value );
                    }
                    parser.next();
                }
            }
            else if ( checkFieldWithDuplicate( parser, "apiMethods", null, parsed ) )
            {
                while ( parser.nextTag() == XmlPullParser.START_TAG )
                {
                    if ( "apiMethod".equals( parser.getName() ) )
                    {
                        String key = null;
                        String value = null;
                        // explode mode.
                        while ( parser.nextTag() == XmlPullParser.START_TAG )
                        {
                            if ( "key".equals( parser.getName() ) )
                            {
                                key = parser.nextText();
                            }
                            else if ( "value".equals( parser.getName() ) )
                            {
                                value = parser.nextText().trim();
                            }
                            else
                            {
                                parser.nextText();
                            }
                        }
                        expression.addApiMethod( key, value );
                    }
                    parser.next();
                }
            }
            else if ( checkFieldWithDuplicate( parser, "deprecation", null, parsed ) )
            {
                expression.setDeprecation( interpolatedTrimmed( parser.nextText(), "deprecation" ) );
            }
            else if ( checkFieldWithDuplicate( parser, "ban", null, parsed ) )
            {
                expression.setBan( interpolatedTrimmed( parser.nextText(), "ban" ) );
            }
            else if ( checkFieldWithDuplicate( parser, "editable", null, parsed ) )
            {
                expression.setEditable( getBooleanValue( interpolatedTrimmed( parser.nextText(), "editable" ), "editable", parser, "true" ) );
            }
            else
            {
                checkUnknownElement( parser, strict );
            }
        }
        return expression;
    } //-- Expression parseExpression( XmlPullParser, boolean )

    /**
     * Method parseExpressionDocumentation.
     * 
     * @param parser
     * @param strict
     * @throws IOException
     * @throws XmlPullParserException
     * @return ExpressionDocumentation
     */
    private ExpressionDocumentation parseExpressionDocumentation( XmlPullParser parser, boolean strict )
        throws IOException, XmlPullParserException
    {
        String tagName = parser.getName();
        ExpressionDocumentation expressionDocumentation = new ExpressionDocumentation();
        for ( int i = parser.getAttributeCount() - 1; i >= 0; i-- )
        {
            String name = parser.getAttributeName( i );
            String value = parser.getAttributeValue( i );

            if ( name.indexOf( ':' ) >= 0 )
            {
                // just ignore attributes with non-default namespace (for example: xmlns:xsi)
            }
            else if ( "xmlns".equals( name ) )
            {
                // ignore xmlns attribute in root class, which is a reserved attribute name
            }
            else
            {
                checkUnknownAttribute( parser, name, tagName, strict );
            }
        }
        java.util.Set parsed = new java.util.HashSet();
        while ( ( strict ? parser.nextTag() : nextTag( parser ) ) == XmlPullParser.START_TAG )
        {
            if ( checkFieldWithDuplicate( parser, "expressions", null, parsed ) )
            {
                java.util.List<Expression> expressions = new java.util.ArrayList<Expression>();
                expressionDocumentation.setExpressions( expressions );
                while ( parser.nextTag() == XmlPullParser.START_TAG )
                {
                    if ( "expression".equals( parser.getName() ) )
                    {
                        expressions.add( parseExpression( parser, strict ) );
                    }
                    else
                    {
                        checkUnknownElement( parser, strict );
                    }
                }
            }
            else
            {
                checkUnknownElement( parser, strict );
            }
        }
        return expressionDocumentation;
    } //-- ExpressionDocumentation parseExpressionDocumentation( XmlPullParser, boolean )

    /**
     * Method read.
     * 
     * @param parser
     * @param strict
     * @throws IOException
     * @throws XmlPullParserException
     * @return ExpressionDocumentation
     */
    private ExpressionDocumentation read( XmlPullParser parser, boolean strict )
        throws IOException, XmlPullParserException
    {
        ExpressionDocumentation expressionDocumentation = null;
        int eventType = parser.getEventType();
        boolean parsed = false;
        while ( eventType != XmlPullParser.END_DOCUMENT )
        {
            if ( eventType == XmlPullParser.START_TAG )
            {
                if ( strict && ! "paramdoc".equals( parser.getName() ) )
                {
                    throw new XmlPullParserException( "Expected root element 'paramdoc' but found '" + parser.getName() + "'", parser, null );
                }
                else if ( parsed )
                {
                    // fallback, already expected a XmlPullParserException due to invalid XML
                    throw new XmlPullParserException( "Duplicated tag: 'paramdoc'", parser, null );
                }
                expressionDocumentation = parseExpressionDocumentation( parser, strict );
                expressionDocumentation.setModelEncoding( parser.getInputEncoding() );
                parsed = true;
            }
            eventType = parser.next();
        }
        if ( parsed )
        {
            return expressionDocumentation;
        }
        throw new XmlPullParserException( "Expected root element 'paramdoc' but found no element at all: invalid XML document", parser, null );
    } //-- ExpressionDocumentation read( XmlPullParser, boolean )

    /**
     * Sets the state of the "add default entities" flag.
     * 
     * @param addDefaultEntities
     */
    public void setAddDefaultEntities( boolean addDefaultEntities )
    {
        this.addDefaultEntities = addDefaultEntities;
    } //-- void setAddDefaultEntities( boolean )

    public static interface ContentTransformer
{
    /**
     * Interpolate the value read from the xpp3 document
     * @param source The source value
     * @param fieldName A description of the field being interpolated. The implementation may use this to
     *                           log stuff.
     * @return The interpolated value.
     */
    String transform( String source, String fieldName );
}

}
