jQuery(function() {
    var $table = AJS.$("#project-config-teams-table");

    function getResourceURL() {
        return contextPath + "/rest/lab-plugin/1.0/teams";
    }
    function getTeam(callback) {
        JIRA.SmartAjax.makeRequest({
            url: getResourceURL(),
            complete: function(xhr, status, response) {
                if (response.successful) {
                    callback(response.data.teams);
                } else {
                    $table.trigger("serverError",
                        [JIRA.SmartAjax.buildSimpleErrorContent(response)]);
                }
            }
        });
    }
    getTeam(function(teams) {
        JIRA.Admin.TeamTable = new JIRA.RestfulTable({
            el: $table,
            url: getResourceURL(),
            entries: teams,
            noEntriesMsg: 'There are currently no teams',
            views: {
                editRow: JIRA.Admin.Student.EditTeamRow,
                row: JIRA.Admin.Team.TeamRow
            }
        });
        jQuery(".jira-restfultable-init").remove();
        JIRA.userhover($table);
    });
});
