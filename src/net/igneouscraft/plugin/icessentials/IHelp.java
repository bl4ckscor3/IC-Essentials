package net.igneouscraft.plugin.icessentials;

/**
 * Contains methods used in the help for each feature
 * @author bl4ckscor3
 */
public interface IHelp
{
	/**
	 * @return The explanation lines of this feature. Each entry in the array will get sent on a new line
	 */
	public abstract String[] getExplanation();
	
	/**
	 * @return The version of this feature (major.minor.bugfix)
	 */
	public abstract String getVersion();
	
	/**
	 * @return The author of this feature
	 */
	public abstract String getAuthor();
}
